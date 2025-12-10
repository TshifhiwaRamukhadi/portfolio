package com.example.assignmentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InstructorDashboard extends AppCompatActivity {
    Button btnCreateTask, btnLogOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_dashboard);
        btnCreateTask = findViewById(R.id.btnCreateTask);
        btnCreateTask.setOnClickListener(v -> startActivity(new Intent(this, CreateTask.class)));
        btnLogOut=findViewById(R.id.btnLogoutInstructor);
        btnLogOut.setOnClickListener(v->startActivity(new Intent(this,MainActivity.class )));
    }
}