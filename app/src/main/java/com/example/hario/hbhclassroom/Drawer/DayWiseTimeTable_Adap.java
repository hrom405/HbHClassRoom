package com.example.hario.hbhclassroom.Drawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hario.hbhclassroom.R;

import java.util.ArrayList;

public class DayWiseTimeTable_Adap extends RecyclerView.Adapter<DayWiseTimeTable_Adap.ViewHolder> {
    ArrayList<RecyclerInfo> arrayList;

    public DayWiseTimeTable_Adap(ArrayList<RecyclerInfo> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public DayWiseTimeTable_Adap.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daywisetimetable_student,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DayWiseTimeTable_Adap.ViewHolder holder, int position) {

      holder.subject.setText(arrayList.get(position).getSubject());
        holder.roomNo.setText(arrayList.get(position).getRoom());
        holder.time.setText(arrayList.get(position).getTime());
        holder.teacherName.setText(arrayList.get(position).getTeacherName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject,time,roomNo,teacherName;

        public ViewHolder(View itemView) {
            super(itemView);
           subject =itemView.findViewById(R.id.DayWise_Subject);
            time = itemView.findViewById(R.id.DayWise_Time);
            roomNo = itemView.findViewById(R.id.DayWise_Room);
            teacherName =itemView.findViewById(R.id.DayWise_Teacher);
        }
    }
}
