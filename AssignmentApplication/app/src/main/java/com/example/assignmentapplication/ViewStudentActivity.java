package com.example.assignmentapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewStudentActivity extends AppCompatActivity {
    ListView listViewStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        listViewStudents = findViewById(R.id.listViewStudents);
        loadStudents();
    }

    private void loadStudents() {
        try {
            DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT name, surname, dob FROM students", null);

            ArrayList<String> studentList = new ArrayList<>();

            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                    String surname = cursor.getString(cursor.getColumnIndexOrThrow("surname"));
                    String dob = cursor.getString(cursor.getColumnIndexOrThrow("dob"));
                    studentList.add("Name: " + name + " " + surname + "\nDOB: " + dob);
                } while (cursor.moveToNext());
            }
            cursor.close();

            if (studentList.isEmpty()) {
                studentList.add("No students found.");
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    studentList
            );
            listViewStudents.setAdapter(adapter);

        } catch (Exception e) {
            Toast.makeText(this, "Error loading students: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
