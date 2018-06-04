package com.example.hario.hbhclassroom.Staff;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hario.hbhclassroom.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ViewTeacherDetails extends AppCompatActivity {
    private TeacherINFO teacherINFO;
    private ImageView tcImage;
    private TextView tcID,tcDesignation,tcName,tcContact,tcDOJ,tcGender,tcAge;
   // static ArrayList<TeacherINFO> arrayList = new ArrayList<>();
    private DatabaseReference databaseReference;
    private Button tcTimeTableButton;
   // private static String name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_teacher_details);

        tcID = findViewById(R.id.view_Teacher_ID_TV);
        tcName = findViewById(R.id.view_Teacher_Name_TV);
        tcDesignation = findViewById(R.id.view_Teacher_Designation_TV);
        tcAge = findViewById(R.id.view_Teacher_Age_TV);
        tcContact = findViewById(R.id.view_Teacher_Contact_No_TV);
        tcDOJ = findViewById(R.id.view_Teacher_DOJ_TV);
        tcGender = findViewById(R.id.view_Teacher_Gender_TV);
        tcImage = findViewById(R.id.view_Teacher_Image);
        tcTimeTableButton = findViewById(R.id.view_teacher_timetable_Button);

        savedInstanceState = getIntent().getExtras();
        String TCID = savedInstanceState.getString("TCID");

        tcID.setText(TCID);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("teacher");


        databaseReference.child("teacherdetails").child(TCID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TeacherINFO item = dataSnapshot.getValue(TeacherINFO.class);
                Log.e(TAG, "Title/DAta: " + item.getTCname());
                tcName.setText(item.getTCname());
                tcAge.setText(""+item.getTCage());
                tcContact.setText(item.getTCcontact());
                tcDesignation.setText(item.getTCdesignation());
                tcDOJ.setText(item.getTCdoj());
                tcGender.setText(item.getTCgender());
                Glide.with(getApplicationContext()).load(item.getTCimage()).into(tcImage);




            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }
}
