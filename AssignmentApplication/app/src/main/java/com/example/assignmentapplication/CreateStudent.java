package com.example.assignmentapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateStudent extends AppCompatActivity {

    EditText editName, editSurname, editDOB;
    Button btnAddStudent, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);

        editName = findViewById(R.id.editStudentName);
        editSurname = findViewById(R.id.editStudentSurname);
        editDOB = findViewById(R.id.editStudentDob);
        btnAddStudent = findViewById(R.id.btnSaveStudent);
        btnBack = findViewById(R.id.btnBack);

        btnAddStudent.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String surname = editSurname.getText().toString();
            String dob = editDOB.getText().toString();

            if (name.isEmpty() || surname.isEmpty() || dob.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("surname", surname);
                values.put("dob", dob);

                long result = db.insert("students", null, values);
                Toast.makeText(this, result != -1 ? "Student added" : "Error adding student", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CreateStudent.this, AdminDashboard.class);
                startActivity(intent);
            }
        });
    }
}
