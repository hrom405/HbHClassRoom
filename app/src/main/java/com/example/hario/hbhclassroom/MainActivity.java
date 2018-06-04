package com.example.hario.hbhclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hario.hbhclassroom.Drawer.NaviDrawerActivity;
import com.example.hario.hbhclassroom.Staff.AddStudentDetails;
import com.example.hario.hbhclassroom.Staff.AddTeacherDetails;

public class MainActivity extends AppCompatActivity {
private Button studentLogin;
private Button facultyLogin;
private Button notice,adminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentLogin = findViewById(R.id.Main_student);
        notice = findViewById(R.id.Main_notice);
        facultyLogin = findViewById(R.id.Main_faculty);
        adminLogin=findViewById(R.id.Admin_faculty);

        //Student OnClick Login
        studentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpAndInActivity.class));
                finish();
            }
        });



        //Notice Onclick
        notice.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,SignUpAndInActivity.class));
            finish();
            }
        });

        //faculty onclick
        facultyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,SignUpAndInActivity.class));
            finish();
            }
        });

        // Admin OnClick Login
        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpAndInActivity.class));
                finish();

            }
        });

    }
}
