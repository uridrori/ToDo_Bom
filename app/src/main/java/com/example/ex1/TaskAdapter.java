package com.example.ex1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {
    private ArrayList<ToDo> _tasks;

    public class TaskHolder extends RecyclerView.ViewHolder {
        TextView text;
        CheckBox check;

        TaskHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.task_text);
            check = itemView.findViewById(R.id.checkbox);
        }
    }

    public TaskAdapter(ArrayList<ToDo> tasks) {
        _tasks = tasks;
    }



    @NonNull
    @Override
    public TaskAdapter.TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.single_task, parent, false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        ToDo todo = _tasks.get(position);
        holder.text.setText(todo.text);
        holder.check.setChecked(false);
    }

    @Override
    public int getItemCount() {
        return _tasks.size();
    }
}
