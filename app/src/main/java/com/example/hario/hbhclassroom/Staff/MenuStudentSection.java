package com.example.hario.hbhclassroom.Staff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hario.hbhclassroom.R;

public class MenuStudentSection extends AppCompatActivity {
    private ImageView addStudent,listAllStudent,attendanceStudent,updateStudent,noticeStudent;
    private TextView addStudentTV,listAllStudentTV,attendanceStudentTV,updateStudentTV,noticeStudentTV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_staff_layout);

        addStudent=(ImageView)findViewById(R.id.teacher_section_image);
        listAllStudent=findViewById(R.id.staff_section_image);
        updateStudent=findViewById(R.id.student_section_image);
        noticeStudent=findViewById(R.id.notice_section_image);
        attendanceStudent=findViewById(R.id.extra_section_image);

        addStudentTV = findViewById(R.id.teacher_section_image_TV);
        listAllStudentTV=findViewById(R.id.staff_section_image_TV);
        updateStudentTV=findViewById(R.id.student_section_image_TV);
        noticeStudentTV=findViewById(R.id.notice_section_image_TV);
        attendanceStudentTV=findViewById(R.id.extra_section_image_TV);


        addStudentTV.setText("Add New Student");
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuStudentSection.this,AddStudentDetails.class));
            }
        });
        updateStudentTV.setText("Student TimeTable");
        updateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuStudentSection.this,AddStudentTimeTable.class));

            }
        });



    }
}
