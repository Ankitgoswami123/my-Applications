package com.example.jharmedia.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jharmedia.Adapter.DashboardAdapter;
import com.example.jharmedia.Adapter.StoryAdapter;
import com.example.jharmedia.Model.DashboardModel;
import com.example.jharmedia.Model.StoryModel;
import com.example.jharmedia.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

RecyclerView storyRecyclerView,dashboardRecyclerView;
ArrayList<StoryModel> list;
ArrayList<DashboardModel> dlist;
ImageView profile_image;
    public HomeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        storyRecyclerView = view.findViewById(R.id.storyRecyclerview);
        profile_image = view.findViewById(R.id.profile_image);
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        list = new ArrayList<>();
        list.add(new StoryModel(R.drawable.billgates,R.drawable.live,R.drawable.billgates,"Bill Gates"));
        list.add(new StoryModel(R.drawable.alia,R.drawable.live,R.drawable.alia,"Alia Bhatt"));
        list.add(new StoryModel(R.drawable.sharukh,R.drawable.live,R.drawable.profile,"Sharukh Khan"));
        list.add(new StoryModel(R.drawable.virat,R.drawable.live,R.drawable.profile,"Virat Kohli"));
        list.add(new StoryModel(R.drawable.dhoni,R.drawable.live,R.drawable.profile,"Dhoni"));
        StoryAdapter adapter = new StoryAdapter(list,getContext()) ;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        storyRecyclerView.setLayoutManager(linearLayoutManager);
        storyRecyclerView.setNestedScrollingEnabled(false);
        storyRecyclerView.setAdapter(adapter);

        dashboardRecyclerView = view.findViewById(R.id.dashboardRecyclerView);
        dlist = new ArrayList<>();
        dlist.add(new DashboardModel(R.drawable.sharukh,R.drawable.sharukh,R.drawable.bookmark,"Sharukh Khan","Actor in Bollywood","10k","5k","500"));
        dlist.add(new DashboardModel(R.drawable.alia,R.drawable.alia,R.drawable.bookmark,"Alia Bhatt","Actoress in Bollywood","10k","5k","500"));
        dlist.add(new DashboardModel(R.drawable.billgates,R.drawable.billgates,R.drawable.bookmark,"Bill gates","Founder of Microsoft","10k","5k","500"));
        dlist.add(new DashboardModel(R.drawable.virat,R.drawable.virat,R.drawable.bookmark,"Virat Kohli","Indian Cricketer and Captain","10k","5k","500"));
        dlist.add(new DashboardModel(R.drawable.dhoni,R.drawable.dhoni,R.drawable.bookmark,"Mahendra singh Dhoni","Indian Cricketer and Retired Captain","10k","5k","500"));

        DashboardAdapter adapter1 = new DashboardAdapter(dlist,getContext());
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        dashboardRecyclerView.setLayoutManager(linearLayoutManager1);
        dashboardRecyclerView.setAdapter(adapter1);

        return  view;
    }
}