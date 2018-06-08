package com.example.hario.hbhclassroom.Staff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hario.hbhclassroom.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class ViewStudentDetails extends AppCompatActivity {
    String TCID="";
    private ImageView stImage;
    private TextView stRoll,stClass,stName,stContact,stSection,stSemester,stGender,stAge,stNameTV,stClassTV,stSemesterTV,stContactTV;
    private DatabaseReference databaseReference;
    private Button stTimeTableButton;
    private LinearLayout linearLayout;
    private StudentINFO item = new StudentINFO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_teacher_details);

        linearLayout=findViewById(R.id.LL2_2);
        linearLayout.setVisibility(View.GONE);

        stRoll = findViewById(R.id.view_Teacher_ID_TV);
        stName = findViewById(R.id.view_Teacher_Name_TV);
        stClass= findViewById(R.id.view_student_class_TV);
        stAge = findViewById(R.id.view_Teacher_Age_TV);
        stContact = findViewById(R.id.view_Teacher_Contact_No_TV);
        stSemester = findViewById(R.id.view_Teacher_DOJ_TV);
        stGender = findViewById(R.id.view_Teacher_Gender_TV);
        stImage = findViewById(R.id.view_Teacher_Image);
        stTimeTableButton = findViewById(R.id.view_teacher_timetable_Button);
        stSection = findViewById(R.id.view_student_class_section_TV);

        stNameTV=findViewById(R.id.view_st_name_tv); stNameTV.setText("Student Name");
        stClassTV=findViewById(R.id.view_st_class_section_TV);  stClassTV.setText("Class & Section");
        stSemesterTV=findViewById(R.id.view_st_semester_tv); stSemesterTV.setText("Current Semester");
        stContactTV=findViewById(R.id.view_st_Contact_tv); stContactTV.setText("Contact No.");



        savedInstanceState = getIntent().getExtras();
        TCID = savedInstanceState.getString("TCID");

        stRoll.setText(TCID);


        stTimeTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String teacherID = String.valueOf(arrayList.get(position).getTCid());
                Intent intent = new Intent(ViewStudentDetails.this,ViewStudentTimeTable.class);
                intent.putExtra("TCID", item.getSTclasss());
                startActivity(intent);
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference().child("student");


        databaseReference.child("studentdetails").child(TCID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                item = dataSnapshot.getValue(StudentINFO.class);
                Log.e(TAG, "Title/DAta: " + item.getSTname());
                stName.setText(item.getSTname());
                stAge.setText(""+item.getSTage());
                stContact.setText(item.getSTcontact());
               // tcDesignation.setText(item.getTCdesignation());
                stSemester.setText(""+item.getSTsemester());
                stGender.setText(item.getSTgender());
                stClass.setText(item.getSTclasss());
                stSection.setText(""+item.getSTsection());

                Glide.with(getApplicationContext()).load(item.getSTimage()).into(stImage);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }
}
