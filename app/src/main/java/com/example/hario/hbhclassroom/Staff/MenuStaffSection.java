package com.example.hario.hbhclassroom.Staff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hario.hbhclassroom.R;

public class MenuStaffSection extends AppCompatActivity {

    private ImageView addStaff,listAllStaff,attendanceStaff,updateStaff,noticeStaff;
    private TextView addStaffTV,listAllStaffTV,attendanceStaffTV,updateStaffTV,noticeStaffTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_staff_layout);

        addStaff=(ImageView)findViewById(R.id.teacher_section_image);
        listAllStaff=findViewById(R.id.staff_section_image);
        updateStaff=findViewById(R.id.student_section_image);
        noticeStaff=findViewById(R.id.notice_section_image);
        attendanceStaff=findViewById(R.id.extra_section_image);

        addStaffTV = findViewById(R.id.teacher_section_image_TV);
        listAllStaffTV=findViewById(R.id.staff_section_image_TV);
        updateStaffTV=findViewById(R.id.student_section_image_TV);
        noticeStaffTV=findViewById(R.id.notice_section_image_TV);
        attendanceStaffTV=findViewById(R.id.extra_section_image_TV);
        
        addStaffTV.setText("Add New Staff");
        addStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuStaffSection.this,AddStaffDetails.class));

            }
        });
        
    }
}
