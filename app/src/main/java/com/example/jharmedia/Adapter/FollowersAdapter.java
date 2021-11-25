package com.example.jharmedia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jharmedia.Model.Follow;
import com.example.jharmedia.Model.userDataModel;
import com.example.jharmedia.R;
import com.example.jharmedia.databinding.FriendsRvSampleBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FollowersAdapter extends  RecyclerView.Adapter<FollowersAdapter.viewHolder> {
   ArrayList<Follow> flist;
   Context context;

    public FollowersAdapter(ArrayList<Follow> flist, Context context) {
        this.flist = flist;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.friends_rv_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Follow follow = flist.get(position);
        FirebaseDatabase.getInstance().getReference().child("Users").child(follow.getFollowedBy()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userDataModel user = snapshot.getValue(userDataModel.class);
                Picasso.get().load(user.getProfileImage()).placeholder(R.drawable.alia).into(holder.binding.profileImage);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return flist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
FriendsRvSampleBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
        binding = FriendsRvSampleBinding.bind(itemView);
        }
    }
}
