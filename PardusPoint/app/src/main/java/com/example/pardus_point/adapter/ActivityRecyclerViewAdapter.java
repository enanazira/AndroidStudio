package com.example.pardus_point.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pardus_point.Activity;
import com.example.pardus_point.R;

import java.util.List;

public class ActivityRecyclerViewAdapter extends RecyclerView.Adapter<ActivityRecyclerViewAdapter.ActivityViewHolder> {

    public List<Activity> activityList;
    private Context context;

    public ActivityRecyclerViewAdapter (Context context,List<Activity> activityList){
        this.context = context;
        this.activityList = activityList;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View activity_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.merit_row,null);
        ActivityViewHolder activityVH = new ActivityViewHolder(activity_row);
        return activityVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {


        holder.tvActivityName.setText(activityList.get(position).getName());
        holder.tvActivityMarks.setText(activityList.get(position).getActivityMarks());

    }

    public int getItemCount(){ return activityList.size();}

    public class ActivityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tvActivityName;
        public TextView tvActivityMarks;

        public ActivityViewHolder(View itemView){
            super(itemView);
            tvActivityName = itemView.findViewById(R.id.tv_activity);
            tvActivityMarks = itemView.findViewById(R.id.tv_marks);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),"Activity Name: " + activityList.get(getAdapterPosition()).getName(),Toast.LENGTH_SHORT).show();
        }
    }
}