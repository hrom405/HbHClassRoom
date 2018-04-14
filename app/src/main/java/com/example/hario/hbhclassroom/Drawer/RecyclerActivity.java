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
    private RecyclerView recyclerView1;
    private RecyclerAdapter recyclerAdapter;
    private DayWiseTimeTable_Adap recyclerAdapter1;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager linearLayoutManager1;
    private ArrayList<RecyclerInfo> arrayList;
    private ArrayList<RecyclerInfo> arrayList1;

    private Context context;

    public RecyclerActivity() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_activity, container, false);
        recyclerView= (RecyclerView) rootView.findViewById(R.id.projectRecylerView);
recyclerView1 = (RecyclerView)rootView.findViewById(R.id.DayWise_TimeTable);

        arrayList = fillProjectDetail();
        arrayList1 = Daywise();

        recyclerAdapter = new RecyclerAdapter(arrayList);
recyclerAdapter1 = new DayWiseTimeTable_Adap(arrayList1);
        linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        linearLayoutManager1=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        recyclerView1.setAdapter(recyclerAdapter1);


        // Inflate the layout for this fragment
        return rootView;
    }
    private ArrayList<RecyclerInfo> fillProjectDetail(){
        ArrayList<RecyclerInfo> pappuinfoArrayList = new ArrayList<>();
     /*   RecyclerInfo p=new RecyclerInfo("Button 1",1);
        pappuinfoArrayList.add(p);
        pappuinfoArrayList.add(new RecyclerInfo("Button 2",2));
*/

        pappuinfoArrayList.add(new RecyclerInfo("Math",94,R.drawable.album1));
        pappuinfoArrayList.add(new RecyclerInfo("Science",68,R.drawable.album2));
        pappuinfoArrayList.add(new RecyclerInfo("Hindi",45,R.drawable.album3));
        pappuinfoArrayList.add(new RecyclerInfo("English",72,R.drawable.album4));
        pappuinfoArrayList.add(new RecyclerInfo("SSt",81,R.drawable.album5));



        return pappuinfoArrayList;
    }

    private ArrayList<RecyclerInfo> Daywise(){
        ArrayList<RecyclerInfo> pappuinfoArrayList = new ArrayList<>();


        pappuinfoArrayList.add(new RecyclerInfo("Math","9:00 - 10:00","Hariom","301"));
        pappuinfoArrayList.add(new RecyclerInfo("English","10:00 - 11:00","hemant","301"));
        pappuinfoArrayList.add(new RecyclerInfo("hindi","11:00 - 12:00","pankaj","301"));
        pappuinfoArrayList.add(new RecyclerInfo("Lunch Time","12:00 - 1:00","",""));
        pappuinfoArrayList.add(new RecyclerInfo("sst","1:00 - 2:00","Aditya","301"));


        return pappuinfoArrayList;
    }



}
