package com.example.assignmentapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class StudentTaskActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Task> taskList;
    TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        listView = findViewById(R.id.taskListView);

        // Sample tasks (you can fetch these from a database)
        taskList = new ArrayList<>();
        taskList.add(new Task("Task 1", "Complete chapter 5", false));
        taskList.add(new Task("Task 2", "Submit assignment", true));

        adapter = new TaskAdapter(this, taskList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Task task = taskList.get(position);

                Intent intent = new Intent(StudentTaskActivity.this, TaskDetailActivity.class);
                intent.putExtra("name", task.taskName);
                intent.putExtra("desc", task.taskDescription);
                intent.putExtra("completed", task.isCompleted);
                startActivity(intent);

            }

        });

    }
}