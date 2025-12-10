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

public class AdminDashboard extends AppCompatActivity {
    Button btnCreateStudent, btnCreateInstructor, btnCreateModule, btnManageStudents, btnManageModules, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        // Correct: Use class-level button variables
        btnManageStudents = findViewById(R.id.btnManageStudents);
        btnManageModules = findViewById(R.id.btnManageModules);
        btnCreateStudent = findViewById(R.id.btnCreateStudent);
        btnCreateInstructor = findViewById(R.id.btnCreateInstructor);
        btnCreateModule = findViewById(R.id.btnCreateModule);
        btnBack = findViewById(R.id.btnBack);

        btnManageStudents.setOnClickListener(v ->
                startActivity(new Intent(this, UpdateDeleteStudentActivity.class)));

        btnManageModules.setOnClickListener(v ->
                startActivity(new Intent(this, UpdateDeleteModuleActivity.class)));

        btnCreateStudent.setOnClickListener(v ->
                startActivity(new Intent(this, CreateStudent.class)));

        btnCreateInstructor.setOnClickListener(v ->
                startActivity(new Intent(this, CreateInstructor.class)));

        btnCreateModule.setOnClickListener(v ->
                startActivity(new Intent(this, CreateModule.class)));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminDashboard.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}