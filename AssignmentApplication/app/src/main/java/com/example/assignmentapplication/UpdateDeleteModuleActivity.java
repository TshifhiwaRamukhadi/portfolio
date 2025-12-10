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

public class UpdateDeleteModuleActivity extends AppCompatActivity {

    EditText editModuleID, editModuleName;
    Button btnUpdateModule, btnDeleteModule, btnViewModules, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_module);

        editModuleID = findViewById(R.id.editModuleID);
        editModuleName = findViewById(R.id.editModuleName);
        btnUpdateModule = findViewById(R.id.btnUpdateModule);
        btnDeleteModule = findViewById(R.id.btnDeleteModule);
        btnViewModules = findViewById(R.id.btnViewModule);
        btnBack = findViewById(R.id.btnBack);

        btnUpdateModule.setOnClickListener(v -> {
            try {
                DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("module_name", editModuleName.getText().toString());

                int rows = db.update("modules", values, "id = ?", new String[]{editModuleID.getText().toString()});
                Toast.makeText(this, rows > 0 ? "Module updated" : "Module not found", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnDeleteModule.setOnClickListener(v -> {
            try {
                DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                int rows = db.delete("modules", "id = ?", new String[]{editModuleID.getText().toString()});
                Toast.makeText(this, rows > 0 ? "Module deleted" : "Module not found", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnViewModules.setOnClickListener(v -> {
            startActivity(new Intent(UpdateDeleteModuleActivity.this, ViewModules.class));
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(UpdateDeleteModuleActivity.this, AdminDashboard.class);
                startActivity(intent);
            }
        });
    }
}
