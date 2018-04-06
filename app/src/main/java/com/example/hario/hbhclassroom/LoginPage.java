package com.example.hario.hbhclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
private EditText Email;
private Button login;
private EditText pwd;
private CheckBox check;
private TextView request;
private TextView forget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);



        Email = findViewById(R.id.HostEMail);
        pwd = findViewById(R.id.HostPwd);
        request = findViewById(R.id.HostSignup);
        login = findViewById(R.id.HostButton);
        check = findViewById(R.id.HostLogin_check);
        forget = findViewById(R.id.HostForget);




    }
}
