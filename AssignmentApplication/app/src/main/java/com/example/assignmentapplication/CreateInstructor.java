package com.example.assignmentapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateInstructor extends AppCompatActivity {
    EditText editInstructorTitle, editInstructorFirstName, editInstructorLastName;
    Button btnSaveInstructor, btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_instructor);
        editInstructorTitle = findViewById(R.id.editInstructorTitle);
        editInstructorFirstName = findViewById(R.id.editInstructorFirstName);
        editInstructorLastName = findViewById(R.id.editInstructorLastName);
        btnSaveInstructor = findViewById(R.id.btnSaveInstructor);
        btnBack = findViewById(R.id.btnBack);


        btnSaveInstructor.setOnClickListener(v -> {
            try {
                DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("title", editInstructorTitle.getText().toString());
                values.put("first_name", editInstructorFirstName.getText().toString());
                values.put("last_name", editInstructorLastName.getText().toString());

                db.insert("instructors", null, values);
                Toast.makeText(this, "Instructor added", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CreateInstructor.this, AdminDashboard.class);
                startActivity(intent);
            }
        });




    }
}