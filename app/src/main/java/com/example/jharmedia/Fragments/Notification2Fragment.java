package com.example.jharmedia.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jharmedia.Adapter.NotificationAdapter;
import com.example.jharmedia.Adapter.ViewPagerAdapter;
import com.example.jharmedia.Model.NotificationModel;
import com.example.jharmedia.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Notification2Fragment extends Fragment {
RecyclerView NotificationRv;
ArrayList<NotificationModel> nlist;

    public Notification2Fragment() {
        // Required empty public constructor


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
  View view= inflater.inflate(R.layout.fragment_notification2, container, false);
  NotificationRv = view.findViewById(R.id.NotificationRv);
  nlist = new ArrayList<>();
  nlist.add(new NotificationModel(R.drawable.alia,"<b>Alia bhatt</b> commented in your post.","just now."));
  nlist.add(new NotificationModel(R.drawable.virat,"<b>Virat Kohli</b> commented in your post.","10 min ago."));
  nlist.add(new NotificationModel(R.drawable.dhoni,"<b>Mahendra singh dhoni</b> commented in your post.","1 hr ago."));
  nlist.add(new NotificationModel(R.drawable.dhoni,"<b>Mahendra singh dhoni</b> commented in your post.","1 hr ago."));
  nlist.add(new NotificationModel(R.drawable.dhoni,"<b>Mahendra singh dhoni</b> commented in your post.","1 hr ago."));
  nlist.add(new NotificationModel(R.drawable.dhoni,"<b>Mahendra singh dhoni</b> commented in your post.","1 hr ago."));
  nlist.add(new NotificationModel(R.drawable.sharukh,"<b>Shahrukh khan</b> tagged you in a post.","just now"));
  nlist.add(new NotificationModel(R.drawable.billgates,"<b>Bill gates</b> commented in your post","just now"));
  nlist.add(new NotificationModel(R.drawable.billgates,"<b>Bill gates</b> commented in your post","just now"));
  nlist.add(new NotificationModel(R.drawable.billgates,"<b>Bill gates</b> commented in your post","just now"));
  nlist.add(new NotificationModel(R.drawable.billgates,"<b>Bill gates</b> commented in your post","just now"));
  nlist.add(new NotificationModel(R.drawable.alia,"<b>Alia bhatt</b> commented in your post","just now"));
        NotificationAdapter adapter = new NotificationAdapter(nlist,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        NotificationRv.setAdapter(adapter);
        NotificationRv.setLayoutManager(layoutManager);
return view;
    }
}