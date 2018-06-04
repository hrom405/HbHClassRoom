package com.example.hario.hbhclassroom.Staff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hario.hbhclassroom.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ViewTeacherAllList extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<TeacherINFO> arrayList =new ArrayList<>();
    private ViewTeacherAllListAdapter viewTeacherAllListAdapter;
    public ViewTeacherAllList(){}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_all_person_recycler_main);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("teacher");

        recyclerView = findViewById(R.id.list_all_person_recycler_mainID);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        databaseReference.child("teacherdetails").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("Count " ,""+dataSnapshot.getChildrenCount());
                for (DataSnapshot postsnap : dataSnapshot.getChildren()) {

                    TeacherINFO item = postsnap.getValue(TeacherINFO.class);
                    arrayList.add(item);
                    Log.e(TAG, "Desginmation: " + item.getTCdesignation());
                    Log.e(TAG, "Title/DAta: " + item.getTCname());
                    Log.e(TAG, "ID: " + item.getTCid());
                    Log.e(TAG, "ImageURL: " + item.getTCimage());

                }
                viewTeacherAllListAdapter = new ViewTeacherAllListAdapter(arrayList);
                recyclerView.setAdapter(viewTeacherAllListAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ViewTeacherAllList.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
