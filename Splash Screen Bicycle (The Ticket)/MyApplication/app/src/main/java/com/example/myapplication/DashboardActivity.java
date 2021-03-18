package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    private TextView textViewForgotPasswd;
    private TextView textViewSingUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //Hooks

        textViewSingUp = findViewById(R.id.textViewSingUp);

        textViewSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SingUpActivity.class);
                startActivity(intent);
            }
        });


        textViewForgotPasswd = findViewById(R.id.already);

        textViewForgotPasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

    }
}