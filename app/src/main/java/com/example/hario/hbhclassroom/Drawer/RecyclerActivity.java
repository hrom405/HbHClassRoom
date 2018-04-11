package com.example.hario.hbhclassroom.Drawer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hario.hbhclassroom.R;

import java.util.ArrayList;

public class RecyclerActivity extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<RecyclerInfo> arrayList;
    private Context context;

    public RecyclerActivity() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_activity, container, false);
        recyclerView= (RecyclerView) rootView.findViewById(R.id.projectRecylerView);


        arrayList = fillProjectDetail();
        recyclerAdapter = new RecyclerAdapter(arrayList);

        linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);


        // Inflate the layout for this fragment
        return rootView;
    }
    private ArrayList<RecyclerInfo> fillProjectDetail(){
        ArrayList<RecyclerInfo> pappuinfoArrayList = new ArrayList<>();
        RecyclerInfo p=new RecyclerInfo("Button 1",1);
        pappuinfoArrayList.add(p);
        pappuinfoArrayList.add(new RecyclerInfo("Button 2",2));

        return pappuinfoArrayList;
    }



}
