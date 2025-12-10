package com.example.assignmentapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {


    Context context;
    ArrayList<Task> tasks;
    LayoutInflater inflater;

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { return tasks.size(); }

    @Override
    public Object getItem(int position) { return tasks.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.task_item, null);

        TextView taskName = convertView.findViewById(R.id.taskName);
        TextView taskDesc = convertView.findViewById(R.id.taskDescription);
        CheckBox taskStatus = convertView.findViewById(R.id.taskCompleted);

        Task task = tasks.get(position);

        taskName.setText(task.taskName);
        taskDesc.setText(task.taskDescription);
        taskStatus.setChecked(task.isCompleted);

        taskStatus.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.isCompleted = isChecked;
            // TODO: update status in database if needed
        });

        return convertView;
    }
}
