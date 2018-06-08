package com.example.hario.hbhclassroom.Staff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.hario.hbhclassroom.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ViewStudentAllList extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<StudentINFO> arrayList =new ArrayList<>();
    private ViewStudentAllListAdapter viewStudentAllListAdapter;
    public ViewStudentAllList(){}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_all_person_recycler_main);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("student");

        recyclerView = findViewById(R.id.list_all_person_recycler_mainID);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        databaseReference.child("studentdetails").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e("Count " ,""+dataSnapshot.getChildrenCount());
                for (DataSnapshot postsnap : dataSnapshot.getChildren()) {

                    StudentINFO item = postsnap.getValue(StudentINFO.class);
                    arrayList.add(item);
                    Log.e(TAG, "Desginmation: " + item.getSTclasss());
                    Log.e(TAG, "Title/DAta: " + item.getSTname());
                    Log.e(TAG, "ID: " + item.getSTrollno());
                    Log.e(TAG, "ImageURL: " + item.getSTimage());

                }
                viewStudentAllListAdapter = new ViewStudentAllListAdapter(arrayList);
                recyclerView.setAdapter(viewStudentAllListAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ViewStudentAllList.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
