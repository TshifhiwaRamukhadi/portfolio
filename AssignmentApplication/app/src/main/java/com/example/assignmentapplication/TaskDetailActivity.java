package com.example.assignmentapplication;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TaskDetailActivity extends AppCompatActivity {

    TextView taskName;
    TextView taskDescription;
    CheckBox taskCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        taskName = findViewById(R.id.taskNameDetail);
        taskDescription = findViewById(R.id.taskDescDetail);
        taskCompleted = findViewById(R.id.taskCheckboxDetail);

        // Get data from intent
        String name = getIntent().getStringExtra("name");
        String desc = getIntent().getStringExtra("desc");
        boolean completed = getIntent().getBooleanExtra("completed", false);

        taskName.setText(name);
        taskDescription.setText(desc);
        taskCompleted.setChecked(completed);


    }
}