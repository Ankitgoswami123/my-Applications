package com.example.jharmedia.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jharmedia.Adapter.FollowersAdapter;
import com.example.jharmedia.Model.Follow;
import com.example.jharmedia.Model.userDataModel;
import com.example.jharmedia.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {
    RecyclerView myfriendRv;
    ArrayList<Follow> flist;
    ImageView changeCoverPhoto, coverPhoto, verifiedAccount,profile_image;
    TextView userKaName, userKaProfession;
    FirebaseAuth auth;
    FirebaseStorage storage;
    FirebaseDatabase database;
    TextView followers,friends,photos;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        database.getReference().child("Users").child(auth.getUid()).
                addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                userDataModel user = snapshot.getValue(userDataModel.class);

                    Picasso.get().
                       load(user.getCoverPhoto()).
                   placeholder(R.drawable.sharukh).into(coverPhoto);
               Picasso.get().load(user.getProfileImage()).placeholder(R.drawable.sharukh)
                      .into(profile_image);

                    userKaName.setText(user.getName());
                    userKaProfession.setText(user.getProfession());
                    followers.setText(user.getFollowerCount()+"");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myfriendRv = view.findViewById(R.id.myfriendRv);
        followers = view.findViewById(R.id.noOfFollowers);
        friends = view.findViewById(R.id.noOfFriends);
        photos = view.findViewById(R.id.noOfPhotos);
        profile_image=view.findViewById(R.id.profile_image);
        verifiedAccount = view.findViewById(R.id.verifiedAccount);
        coverPhoto = view.findViewById(R.id.coverPhoto);
        changeCoverPhoto = view.findViewById(R.id.changeCoverPhoto);
        userKaName = view.findViewById(R.id.userKaName);
        userKaProfession = view.findViewById(R.id.userKaProfession);
        flist = new ArrayList<>();
//
        FollowersAdapter friendAdapter = new FollowersAdapter(flist, getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        myfriendRv.setLayoutManager(linearLayoutManager);
        myfriendRv.setAdapter(friendAdapter);
        database.getReference().child("Users").child(auth.getUid()).child("followers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()
                     ) {
                    flist.clear();
                    Follow follow = dataSnapshot.getValue(Follow.class);
                    flist.add(follow);
                }
                friendAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        verifiedAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 22);
            }
        });
        changeCoverPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 11);
            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

           if (requestCode == 11){
               if (data.getData() != null) {
                   Uri uri = data.getData();
                   coverPhoto.setImageURI(uri);
                   final StorageReference reference = storage.getReference().child("cover_photo").
                           child(FirebaseAuth.getInstance().getUid());
                   reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                       @Override
                       public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                           Toast.makeText(getContext(), "Cover photo is saved.", Toast.LENGTH_SHORT).show();
                           reference.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                               @Override
                               public void onComplete(@NonNull Task<Uri> task) {

                                   database.getReference().child("Users").child(auth.getUid()).child("coverPhoto").setValue(uri.toString());
                               }
                           });
                       }
                   });
               }
           }
           else{
               if (data.getData() != null) {
                   Uri uri = data.getData();
                   profile_image.setImageURI(uri);
                   final StorageReference reference = storage.getReference().child("profile_image").
                           child(FirebaseAuth.getInstance().getUid());
                   reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                       @Override
                       public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                           Toast.makeText(getContext(), "Profile photo is saved.", Toast.LENGTH_SHORT).show();
                           reference.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                               @Override
                               public void onComplete(@NonNull Task<Uri> task) {

                                   database.getReference().child("Users").child(auth.getUid()).child("profileImage").setValue(uri.toString());
                               }
                           });
                       }
                   });
               }
           }

        }
    }
