package com.example.assignmentapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentDashboard extends AppCompatActivity {
    Button btnViewMyTasks, btnLogout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
        btnViewMyTasks = findViewById(R.id.btnViewMyTasks);
        btnViewMyTasks.setOnClickListener(v -> startActivity(new Intent(this, ViewTaskActivity.class)));
        btnLogout =findViewById(R.id.btnLogoutStudent);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(StudentDashboard.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}