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

public class CreateTask extends AppCompatActivity {
    EditText editTaskName, editDueDate, editModuleName;
    Button btnSaveTask, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        editTaskName = findViewById(R.id.editTaskName);
        editDueDate = findViewById(R.id.editDueDate);
        editModuleName = findViewById(R.id.editModuleName);
        btnSaveTask = findViewById(R.id.btnSaveTask);
        btnBack = findViewById(R.id.btnBack);

        btnSaveTask.setOnClickListener(v -> {
            try {
                DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("task_name", editTaskName.getText().toString());
                values.put("due_date", editDueDate.getText().toString());
                values.put("module_name", editModuleName.getText().toString());

                db.insert("tasks", null, values);
                Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CreateTask.this, InstructorDashboard.class);
                startActivity(intent);
            }
        });

    }
}