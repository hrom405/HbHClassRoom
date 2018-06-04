package com.example.hario.hbhclassroom.Staff;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hario.hbhclassroom.R;

import java.util.ArrayList;

public class ViewTeacherAllListAdapter extends RecyclerView.Adapter<ViewTeacherAllListAdapter.ViewHolder> {
    ArrayList<TeacherINFO> arrayList;
    Context context;
    public ViewTeacherAllListAdapter() {}

    public ViewTeacherAllListAdapter(ArrayList<TeacherINFO> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewTeacherAllListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_all_teacher_recycler,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTeacherAllListAdapter.ViewHolder holder, final int position) {
        Glide.with(holder.teacherImage.getContext()).load(arrayList.get(position).getTCimage()).into(holder.teacherImage);
        holder.teacherName.setText(arrayList.get(position).getTCname());
        holder.teacherID.setText(""+arrayList.get(position).getTCid());
        holder.teacherDesignation.setText(arrayList.get(position).getTCdesignation());

        holder.viewTeacherDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teacherID = String.valueOf(arrayList.get(position).getTCid());
                Intent intent = new Intent(view.getContext(), ViewTeacherDetails.class);
                intent.putExtra("TCID", teacherID);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView teacherImage;
        TextView teacherID, teacherName, teacherDesignation;
        Button viewTeacherDetails;

        public ViewHolder(View itemView) {
            super(itemView);
            teacherImage = itemView.findViewById(R.id.list_teacher_imageView);
            teacherName = itemView.findViewById(R.id.list_teacher_Name);
            teacherDesignation = itemView.findViewById(R.id.list_teacher_Designation);
            teacherID = itemView.findViewById(R.id.list_teacher_ID);
            viewTeacherDetails = itemView.findViewById(R.id.list_teacher_ViewFullDetails);
        }
    }
}
