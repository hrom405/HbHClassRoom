package com.example.hario.hbhclassroom.Staff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hario.hbhclassroom.R;

public class MenuTeacherSection extends AppCompatActivity{
    private ImageView addTeacher,listAllTeacher,attendanceTeacher,updateTeacher,noticeTeacher;
    private TextView addTeacherTV,listAllTeacherTV,attendanceTeacherTV,updateTeacherTV,noticeTeacherTV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_staff_layout);

        addTeacher=(ImageView)findViewById(R.id.teacher_section_image);
        listAllTeacher=findViewById(R.id.staff_section_image);
        updateTeacher=findViewById(R.id.student_section_image);
        noticeTeacher=findViewById(R.id.notice_section_image);
        attendanceTeacher=findViewById(R.id.extra_section_image);

        addTeacherTV = findViewById(R.id.teacher_section_image_TV);
        listAllTeacherTV=findViewById(R.id.staff_section_image_TV);
        updateTeacherTV=findViewById(R.id.student_section_image_TV);
        noticeTeacherTV=findViewById(R.id.notice_section_image_TV);
        attendanceTeacherTV=findViewById(R.id.extra_section_image_TV);

        addTeacherTV.setText("Add New Teacher");
        addTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuTeacherSection.this,AddTeacherDetails.class));
            }
        });

        listAllTeacherTV.setText("List All Teachers");
        listAllTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuTeacherSection.this,ViewTeacherAllList.class));
            }
        });
        updateTeacherTV.setText("Teacher TimeTable Details");
        updateTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuTeacherSection.this,AddTeacherTimeTable.class));
            }
        });
        noticeTeacherTV.setText("Notice");
        attendanceTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}
