package com.example.assignmentapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewModules extends AppCompatActivity {

    ListView listViewModules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_modules);

        listViewModules = findViewById(R.id.listViewModules);
        loadModules();
    }

    private void loadModules() {
        try {
            DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT module_name, module_code, duration FROM modules", null);

            ArrayList<String> moduleList = new ArrayList<>();

            if (cursor.moveToFirst()) {
                do {
                    String moduleName = cursor.getString(cursor.getColumnIndexOrThrow("module_name"));
                    String moduleCode = cursor.getString(cursor.getColumnIndexOrThrow("module_code"));
                    String duration = cursor.getString(cursor.getColumnIndexOrThrow("duration"));

                    moduleList.add("Module: " + moduleName +
                            "\nCode: " + moduleCode +
                            "\nDuration: " + duration);
                } while (cursor.moveToNext());
            }
            cursor.close();

            if (moduleList.isEmpty()) {
                moduleList.add("No modules found.");
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    moduleList
            );
            listViewModules.setAdapter(adapter);

        } catch (Exception e) {
            Toast.makeText(this, "Error loading modules: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
