package com.example.jharmedia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jharmedia.Model.DashboardModel;
import com.example.jharmedia.R;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.viewHolder> {
ArrayList<DashboardModel> list;
Context context;

    public DashboardAdapter(ArrayList<DashboardModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(context).inflate(R.layout.dashboardrvsample,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
  DashboardModel model = list.get(position);
  holder.profile_image.setImageResource(model.getProfile_image());
  holder.postImg.setImageResource(model.getPostImg());
  holder.saveImg.setImageResource(model.getSaveImg());
  holder.About.setText(model.getAbout());
  holder.userName.setText(model.getUserName());
  holder.like.setText(model.getLike());
  holder.comment.setText(model.getComment());
  holder.share.setText(model.getShare());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
   ImageView profile_image,postImg,saveImg;
   TextView userName,About,like,comment,share;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.profile_image);
          postImg = itemView.findViewById(R.id.postImg);
        saveImg = itemView.findViewById(R.id.saveImg);
         userName = itemView.findViewById(R.id.userName);
          About = itemView.findViewById(R.id.About);
        like = itemView.findViewById(R.id.like);
        comment = itemView.findViewById(R.id.comment);
        share = itemView.findViewById(R.id.share);
        }
    }
}
