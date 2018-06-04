package com.example.hario.hbhclassroom.Staff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hario.hbhclassroom.R;

public class MenuStaff extends AppCompatActivity {
    private ImageView teacher,staff,student,notice,extra;
    private TextView teacherTV,staffTV,studentTV,noticeTV,extraTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_staff_layout);

        teacher=(ImageView)findViewById(R.id.teacher_section_image);
        staff=findViewById(R.id.staff_section_image);
        student=findViewById(R.id.student_section_image);
        notice=findViewById(R.id.notice_section_image);
        extra=findViewById(R.id.extra_section_image);

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuStaff.this,MenuTeacherSection.class));
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuStaff.this,MenuStudentSection.class));

            }
        });
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuStaff.this,MenuStudentSection.class));
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuStaff.this,MenuNoticeSection.class));
            }
        });
        extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuStaff.this,MenuExtraSection.class));
            }
        });

    }
}
