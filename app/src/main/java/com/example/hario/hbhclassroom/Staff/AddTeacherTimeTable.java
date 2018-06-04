package com.example.hario.hbhclassroom.Staff;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hario.hbhclassroom.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTeacherTimeTable extends AppCompatActivity {
    private EditText tcID,cls,s1,s2,s3,s4,s5,s6,s7,s8,day,t1,t2,t3,t4,t5,t6,t7,t8;
    private Button addTimeTable;
    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student_timetable_layout);


        databaseReference = FirebaseDatabase.getInstance().getReference();
        progressDialog = new ProgressDialog(this);


        tcID = findViewById(R.id.add_teacher_timetable_teacherID);
        //tcID.setVisibility(View.GONE);
        cls=findViewById(R.id.add_teacher_timetable_teacherClass);
        cls.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        cls.setVisibility(View.GONE);
        day=findViewById(R.id.add_teacher_timetable_DAY); day.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        s1=findViewById(R.id.add_subject1); s1.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        s2=findViewById(R.id.add_subject2); s2.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        s3=findViewById(R.id.add_subject3); s3.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        s4=findViewById(R.id.add_subject4); s4.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        s5=findViewById(R.id.add_subject5); s5.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        s6=findViewById(R.id.add_subject6); s6.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        s7=findViewById(R.id.add_subject7); s7.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        s8=findViewById(R.id.add_subject8); s8.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        t1=findViewById(R.id.add_tchrID1); t1.setHint("Class"); t1.setFilters(new InputFilter[]{new InputFilter.AllCaps()});t1.setInputType(1);
        t2=findViewById(R.id.add_tchrID2); t2.setHint("Class"); t2.setFilters(new InputFilter[]{new InputFilter.AllCaps()});t2.setInputType(1);
        t3=findViewById(R.id.add_tchrID3); t3.setHint("Class"); t3.setFilters(new InputFilter[]{new InputFilter.AllCaps()});t3.setInputType(1);
        t4=findViewById(R.id.add_tchrID4); t4.setHint("Class"); t4.setFilters(new InputFilter[]{new InputFilter.AllCaps()});t4.setInputType(1);
        t5=findViewById(R.id.add_tchrID5); t5.setHint("Class"); t5.setFilters(new InputFilter[]{new InputFilter.AllCaps()});t5.setInputType(1);
        t6=findViewById(R.id.add_tchrID6); t6.setHint("Class"); t6.setFilters(new InputFilter[]{new InputFilter.AllCaps()});t6.setInputType(1);
        t7=findViewById(R.id.add_tchrID7); t7.setHint("Class"); t7.setFilters(new InputFilter[]{new InputFilter.AllCaps()});t7.setInputType(1);
        t8=findViewById(R.id.add_tchrID8); t8.setHint("Class"); t8.setFilters(new InputFilter[]{new InputFilter.AllCaps()});t8.setInputType(1);



        addTimeTable=findViewById(R.id.add_timetable_button);
        addTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadToFirebase();

            }
        });

    }
    public void UploadToFirebase() {


        final String tcid = tcID.getText().toString();
        final String clss = cls.getText().toString();
        final String Day = day.getText().toString();
        final String S1 = s1.getText().toString();
        final String S2 = s2.getText().toString();
        final String S3 = s3.getText().toString();
        final String S4 = s4.getText().toString();
        final String S5 = s5.getText().toString();
        final String S6 = s6.getText().toString();
        final String S7 = s7.getText().toString();
        final String S8 = s8.getText().toString();
        final String T1= t1.getText().toString();
        final String T2= t2.getText().toString();
        final String T3= t3.getText().toString();
        final String T4= t4.getText().toString();
        final String T5= t5.getText().toString();
        final String T6= t6.getText().toString();
        final String T7= t7.getText().toString();
        final String T8= t8.getText().toString();

        if (tcid!=null &&Day!=null)
        {
            progressDialog.setMessage("Uploading...");
            progressDialog.show();

            final TeacherTimeTableINFO teacherTimeTableTCID = new TeacherTimeTableINFO(clss,Day, S1,S2,
                    S3,S4,S5,S6,S7,S8,tcid);
            final TeacherTimeTableINFO teacherTimeTableCLASS = new TeacherTimeTableINFO(clss,Day,S1,S2,
                    S3,S4,S5,S6,S7,S8);
            final TeacherTimeTableINFO teacherTimeTableTINO= new TeacherTimeTableINFO(tcid,clss,Day,T1,T2,T3,T4,T5,T6,T7,T8,Day+"2");


            databaseReference.child("teacher").child("timetable").child(tcid).child(Day).setValue(teacherTimeTableTCID);
            databaseReference.child("teacher").child("timetable").child(tcid).child(Day+"2").setValue(teacherTimeTableTINO);
            //databaseReference.child("class").child(clss).child("timetable").child(Day).setValue(teacherTimeTableCLASS);
            //databaseReference.child("class").child(clss).child("timetable").child(Day+"2").setValue(teacherTimeTableTINO);
            progressDialog.hide();

            Toast.makeText(getApplicationContext(), tcid+"'s TimeTable Added Successfully!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(AddTeacherTimeTable.this, MenuTeacherSection.class));
            finish();

        } else {
            Toast.makeText(AddTeacherTimeTable.this, "Please Insert Above 2 Details Again ", Toast.LENGTH_LONG).show();
        }
    }
}
