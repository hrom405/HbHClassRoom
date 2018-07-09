package com.example.hario.hbhclassroom.Staff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hario.hbhclassroom.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import static android.content.ContentValues.TAG;

public class ViewTeacherTimeTable extends AppCompatActivity {


    private TextView teacherID, sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,cls1,cls2,cls3,cls4,cls5,cls6,cls7,cls8,cls,r1,r2,r3,r4,r5,r6,r7,r8;
    private Spinner selectDay;
    private DatabaseReference databaseReference;
    private TeacherTimeTableINFO teacherTimeTableINFO;
    String Choice="",TCID="";
    private Button addButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_teacher_timetable_layout);

        savedInstanceState = getIntent().getExtras();
        TCID = savedInstanceState.getString("TCID");

        selectDay=findViewById(R.id.view_teacher_tt_Spinner_selectDAY);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Select_Week_Day,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectDay.setAdapter(adapter);
        selectDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Choice = adapterView.getItemAtPosition(i).toString();
                Log.e(TAG, "onItemSelected: " + Choice);
                updateUI(Choice);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });



        teacherID=findViewById(R.id.view_teacher_tt_teacherID);
        teacherID.setText(TCID);

        cls=findViewById(R.id.view_teacher_tt_className);
        cls.setVisibility(View.GONE);
        addButton=findViewById(R.id.view_teacher_TT_button);
        addButton.setVisibility(View.GONE);

        sub1=findViewById(R.id.view_teacher_tt_subject1);
        sub2=findViewById(R.id.view_teacher_tt_subject2);
        sub3=findViewById(R.id.view_teacher_tt_subject3);
        sub4=findViewById(R.id.view_teacher_tt_subject4);
        sub5=findViewById(R.id.view_teacher_tt_subject5);
        sub6=findViewById(R.id.view_teacher_tt_subject6);
        sub7=findViewById(R.id.view_teacher_tt_subject7);
        sub8=findViewById(R.id.view_teacher_tt_subject8);

        cls1=findViewById(R.id.view_teacher_tt_ClassID1);
        cls2=findViewById(R.id.view_teacher_tt_ClassID2);
        cls3=findViewById(R.id.view_teacher_tt_ClassID3);
        cls4=findViewById(R.id.view_teacher_tt_ClassID4);
        cls5=findViewById(R.id.view_teacher_tt_ClassID5);
        cls6=findViewById(R.id.view_teacher_tt_ClassID6);
        cls7=findViewById(R.id.view_teacher_tt_ClassID7);
        cls8=findViewById(R.id.view_teacher_tt_ClassID8);

        r1=findViewById(R.id.view_teacher_tt_RoomNO1);
        r2=findViewById(R.id.view_teacher_tt_RoomNO2);
        r3=findViewById(R.id.view_teacher_tt_RoomNO3);
        r4=findViewById(R.id.view_teacher_tt_RoomNO4);
        r5=findViewById(R.id.view_teacher_tt_RoomNO5);
        r6=findViewById(R.id.view_teacher_tt_RoomNO6);
        r7=findViewById(R.id.view_teacher_tt_RoomNO7);
        r8=findViewById(R.id.view_teacher_tt_RoomNO8);


    }
    private void updateUI(final String choice) {

        databaseReference = FirebaseDatabase.getInstance().getReference().child("teacher").child("timetable");

        databaseReference.child(TCID).child(choice).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(TAG, "updateUI: " + TCID + " "+choice);
                TeacherTimeTableINFO teacherTimeTableINFO = dataSnapshot.getValue(TeacherTimeTableINFO.class);
                Log.e(TAG, "Title/DAta: " + teacherTimeTableINFO.getSubject1());

                //teacherID.setText(teacherTimeTableINFO.getTeacherID());

                sub1.setText(teacherTimeTableINFO.getSubject1());
                sub2.setText(teacherTimeTableINFO.getSubject2());
                sub3.setText(teacherTimeTableINFO.getSubject3());
                sub4.setText(teacherTimeTableINFO.getSubject4());
                sub5.setText(teacherTimeTableINFO.getSubject5());
                sub6.setText(teacherTimeTableINFO.getSubject6());
                sub7.setText(teacherTimeTableINFO.getSubject7());
                sub8.setText(teacherTimeTableINFO.getSubject8());
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {
                //    Toast.makeText(HostActivityMain.this, "LogOut Successful", Toast.LENGTH_SHORT).show();

            }
        });
        databaseReference.child(TCID).child(choice+"3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(TAG, "updateUI: " + TCID + " "+choice);
                TeacherTimeTableINFO teacherTimeTableRoomNo = dataSnapshot.getValue(TeacherTimeTableINFO.class);
                Log.e(TAG, "Title/DAta: " + teacherTimeTableRoomNo.getRoom1());

                //teacherID.setText(teacherTimeTableINFO.getTeacherID());

                r1.setText(teacherTimeTableRoomNo.getRoom1());
                r2.setText(teacherTimeTableRoomNo.getRoom2());
                r3.setText(teacherTimeTableRoomNo.getRoom3());
                r4.setText(teacherTimeTableRoomNo.getRoom4());
                r5.setText(teacherTimeTableRoomNo.getRoom5());
                r6.setText(teacherTimeTableRoomNo.getRoom6());
                r7.setText(teacherTimeTableRoomNo.getRoom7());
                r8.setText(teacherTimeTableRoomNo.getRoom8());
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {
                //    Toast.makeText(HostActivityMain.this, "LogOut Successful", Toast.LENGTH_SHORT).show();

            }
        });




        databaseReference.child(TCID).child(choice+"2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final TeacherTimeTableINFO teacherTimeTableINFO2 = dataSnapshot.getValue(TeacherTimeTableINFO.class);
                Log.e(TAG, "Title/DAta: " + teacherTimeTableINFO2.getTeacherID());

                cls1.setText(teacherTimeTableINFO2.getTc1());
                cls2.setText(teacherTimeTableINFO2.getTc2());
                cls3.setText(teacherTimeTableINFO2.getTc3());
                cls4.setText(teacherTimeTableINFO2.getTc4());
                cls5.setText(teacherTimeTableINFO2.getTc5());
                cls6.setText(teacherTimeTableINFO2.getTc6());
                cls7.setText(teacherTimeTableINFO2.getTc7());
                cls8.setText(teacherTimeTableINFO2.getTc8());


                if(teacherTimeTableINFO2.getTc1().equals(""))
                    cls1.setVisibility(View.GONE);
                else cls1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String teacherID = teacherTimeTableINFO2.getTc1();
                        Intent intent = new Intent(ViewTeacherTimeTable.this,ViewTeacherDetails.class);
                        intent.putExtra("TCID", teacherID);
                        startActivity(intent);
                    }
                });
                if(teacherTimeTableINFO2.getTc2().equals(""))
                    cls2.setVisibility(View.GONE);
                else cls3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String teacherID = teacherTimeTableINFO2.getTc1();
                        Intent intent = new Intent(ViewTeacherTimeTable.this,ViewTeacherDetails.class);
                        intent.putExtra("TCID", teacherID);
                        startActivity(intent);
                    }
                });
                if(teacherTimeTableINFO2.getTc3().equals(""))
                    cls3.setVisibility(View.GONE);
                else cls3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String teacherID = teacherTimeTableINFO2.getTc1();
                        Intent intent = new Intent(ViewTeacherTimeTable.this,ViewStudentTimeTable.class);
                        intent.putExtra("TCID", teacherID);
                        startActivity(intent);   }
                });
                if(teacherTimeTableINFO2.getTc4().equals(""))
                    cls4.setVisibility(View.GONE);
                else cls4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String teacherID = teacherTimeTableINFO2.getTc1();
                        Intent intent = new Intent(ViewTeacherTimeTable.this,ViewStudentTimeTable.class);
                        intent.putExtra("TCID", teacherID);
                        startActivity(intent);    }
                });
                if(teacherTimeTableINFO2.getTc5().equals(""))
                    cls5.setVisibility(View.GONE);
                else cls5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String teacherID = teacherTimeTableINFO2.getTc1();
                        Intent intent = new Intent(ViewTeacherTimeTable.this,ViewStudentTimeTable.class);
                        intent.putExtra("TCID", teacherID);
                        startActivity(intent);     }
                });
                if(teacherTimeTableINFO2.getTc6().equals(""))
                    cls6.setVisibility(View.GONE);
                else cls6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String teacherID = teacherTimeTableINFO2.getTc1();
                        Intent intent = new Intent(ViewTeacherTimeTable.this,ViewStudentTimeTable.class);
                        intent.putExtra("TCID", teacherID);
                        startActivity(intent);     }
                });
                if(teacherTimeTableINFO2.getTc7().equals(""))
                    cls7.setVisibility(View.GONE);
                else cls7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String teacherID = teacherTimeTableINFO2.getTc1();
                        Intent intent = new Intent(ViewTeacherTimeTable.this,ViewStudentTimeTable.class);
                        intent.putExtra("TCID", teacherID);
                        startActivity(intent);    }
                });
                if(teacherTimeTableINFO2.getTc8().equals(""))
                    cls8.setVisibility(View.GONE);
                else cls8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String teacherID = teacherTimeTableINFO2.getTc1();
                        Intent intent = new Intent(ViewTeacherTimeTable.this,ViewStudentTimeTable.class);
                        intent.putExtra("TCID", teacherID);
                        startActivity(intent);   }
                });

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                //    Toast.makeText(HostActivityMain.this, "LogOut Successful", Toast.LENGTH_SHORT).show();

            }
        });



    }

}
