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

public class ViewStudentAllListAdapter extends RecyclerView.Adapter<ViewStudentAllListAdapter.ViewHolder> {
    ArrayList<StudentINFO> arrayList;
    Context context;
    public ViewStudentAllListAdapter() {}

    public  ViewStudentAllListAdapter(ArrayList<StudentINFO> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewStudentAllListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_all_teacher_recycler,parent,false);
        final ViewStudentAllListAdapter.ViewHolder viewHolder = new ViewStudentAllListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewStudentAllListAdapter.ViewHolder holder, final int position) {
        Glide.with(holder.studentImage.getContext()).load(arrayList.get(position).getSTimage()).into(holder.studentImage);
        holder.studentName.setText(arrayList.get(position).getSTname());
        holder.studentID.setText(arrayList.get(position).getSTrollno());
        holder.studentClass.setText(arrayList.get(position).getSTclasss());


        holder.viewTeacherDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teacherID = String.valueOf(arrayList.get(position).getSTrollno());
                Intent intent = new Intent(view.getContext(), ViewStudentDetails.class);
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

        ImageView studentImage;
        TextView studentID, studentName, studentClass;
        Button viewTeacherDetails;

        public ViewHolder(View itemView) {
            super(itemView);
            studentImage = itemView.findViewById(R.id.list_teacher_imageView);
            studentName = itemView.findViewById(R.id.list_teacher_Name);
            studentClass= itemView.findViewById(R.id.list_teacher_Designation);
            studentID = itemView.findViewById(R.id.list_teacher_ID);
            viewTeacherDetails = itemView.findViewById(R.id.list_teacher_ViewFullDetails);
        }
    }
}
