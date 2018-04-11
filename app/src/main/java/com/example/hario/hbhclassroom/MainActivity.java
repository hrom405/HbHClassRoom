package com.example.hario.hbhclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hario.hbhclassroom.Drawer.NaviDrawerActivity;

public class MainActivity extends AppCompatActivity {
private Button studentLogin;
private Button facultyLogin;
private Button notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentLogin = findViewById(R.id.Main_student);
        notice = findViewById(R.id.Main_notice);
        facultyLogin = findViewById(R.id.Main_faculty);

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
            startActivity(new Intent(MainActivity.this,NaviDrawerActivity.class));
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

    }
}
