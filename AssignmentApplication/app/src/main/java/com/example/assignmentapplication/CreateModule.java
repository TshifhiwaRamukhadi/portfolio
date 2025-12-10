package com.example.assignmentapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateModule extends AppCompatActivity {

    EditText editModuleName, editModuleCode, editModuleDuration;
    Button btnAddModule, btnBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_module);

        editModuleName = findViewById(R.id.editModuleName);
        editModuleCode = findViewById(R.id.editModuleCode);
        editModuleDuration = findViewById(R.id.editModuleDuration);
        btnAddModule = findViewById(R.id.btnSaveModule);
        btnBack = findViewById(R.id.btnBack);

        btnAddModule.setOnClickListener(v -> {
            String moduleName = editModuleName.getText().toString().trim();
            String moduleCode = editModuleCode.getText().toString().trim();
            String duration = editModuleDuration.getText().toString().trim();

            if (moduleName.isEmpty() || moduleCode.isEmpty()) {
                Toast.makeText(this, "Please fill in module name and code", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("module_name", moduleName);
                values.put("module_code", moduleCode);
                values.put("duration", duration);

                long result = db.insert("modules", null, values);
                if (result != -1) {
                    Toast.makeText(this, "Module added successfully!", Toast.LENGTH_SHORT).show();
                    // Optional: clear inputs after successful insert
                    editModuleName.setText("");
                    editModuleCode.setText("");
                    editModuleDuration.setText("");
                } else {
                    Toast.makeText(this, "Failed to add module.", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(CreateModule.this, AdminDashboard.class);
                startActivity(intent);
            }
        });
    }
}
