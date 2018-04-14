package com.example.hario.hbhclassroom.Drawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hario.hbhclassroom.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<RecyclerInfo> arrayList;

    public RecyclerAdapter(ArrayList<RecyclerInfo> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_attendence_percentage,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.count.setText(""+arrayList.get(position).getPercentage());
        holder.thmbnail.setImageResource(arrayList.get(position).getThumbnail());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,count;
        ImageView thmbnail;
        public ViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.Card_subject);
            count = itemView.findViewById(R.id.Card_percen);
            thmbnail = itemView.findViewById(R.id.Card_thumbnail);
        }
    }
}
