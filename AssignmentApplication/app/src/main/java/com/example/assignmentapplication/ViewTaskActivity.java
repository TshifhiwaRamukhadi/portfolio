package com.example.assignmentapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ViewTaskActivity extends AppCompatActivity {
    ListView listViewTasks;
    ArrayList<String> taskList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
        listViewTasks = findViewById(R.id.listViewTasks);
        taskList = new ArrayList<>();

        try {
            DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT task_name, due_date FROM tasks", null);
            while (cursor.moveToNext()) {
                String task = cursor.getString(0) + " - Due: " + cursor.getString(1);
                taskList.add(task);
            }
            cursor.close();

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
            listViewTasks.setAdapter(adapter);
        } catch (Exception e) {
            Toast.makeText(this, "Error loading tasks: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }








    }
}

