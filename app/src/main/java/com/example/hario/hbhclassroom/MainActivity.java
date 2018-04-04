package com.example.hario.hbhclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

// Aditya Ka Chan
        // Student ONclick
        studentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        //Notice Onclick
notice.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});

//faculty onclick
facultyLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});







    }
}
