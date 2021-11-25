package com.example.jharmedia.Adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jharmedia.Model.NotificationModel;
import com.example.jharmedia.R;

import java.util.ArrayList;

public class NotificationAdapter extends  RecyclerView.Adapter<NotificationAdapter.viewHolder>{
 ArrayList<NotificationModel> nlist;
 Context context;

    public NotificationAdapter(ArrayList<NotificationModel> nlist, Context context) {
        this.nlist = nlist;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification2sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
NotificationModel model = nlist.get(position);
holder.profile.setImageResource(model.getProfile());
holder.notificationTime.setText(model.getNotificationTime());
holder.notificationText.setText(Html.fromHtml(model.getNotificationText()));
    }

    @Override
    public int getItemCount() {
        return nlist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
ImageView profile;
TextView notificationText,notificationTime;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile_image);
            notificationText = itemView.findViewById(R.id.notificationText);
            notificationTime = itemView.findViewById(R.id.notificationTime);
        }
    }
}
