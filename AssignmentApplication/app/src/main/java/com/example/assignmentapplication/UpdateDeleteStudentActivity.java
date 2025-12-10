package com.example.assignmentapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateDeleteStudentActivity extends AppCompatActivity {
    EditText editStudentName;
    Button btnUpdateStudent, btnDeleteStudent, btnViewStudents, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_student);

        editStudentName = findViewById(R.id.editStudentName);
        btnUpdateStudent = findViewById(R.id.btnUpdateStudent);
        btnDeleteStudent = findViewById(R.id.btnDeleteStudent);
        btnViewStudents = findViewById(R.id.btnViewStudent);
        btnBack = findViewById(R.id.btnBack);

        // ❌ Disable update logic
        btnUpdateStudent.setOnClickListener(v ->
                Toast.makeText(this, "Update not supported. Only delete is allowed.", Toast.LENGTH_SHORT).show()
        );

        // ✅ Delete Student by name
        btnDeleteStudent.setOnClickListener(v -> {
            String currentName = editStudentName.getText().toString().trim();

            if (currentName.isEmpty()) {
                Toast.makeText(this, "Please enter student name", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                int rows = db.delete("students", "name = ?", new String[]{currentName});
                Toast.makeText(this, rows > 0 ? "Student deleted" : "Student not found", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnViewStudents.setOnClickListener(v -> {
            try {
                startActivity(new Intent(UpdateDeleteStudentActivity.this, ViewStudentActivity.class));
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UpdateDeleteStudentActivity.this, AdminDashboard.class);
                startActivity(intent);
            }
        });

    }
}


