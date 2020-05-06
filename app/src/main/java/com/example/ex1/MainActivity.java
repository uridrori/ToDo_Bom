package com.example.ex1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    RecyclerView Task_Recycler;
    Button editButton;
    ArrayList<ToDo> tasks;
    TaskAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tasks = new ArrayList<>();
        adapter = new TaskAdapter(tasks);
        editText = findViewById(R.id.NewList);
        editButton = findViewById(R.id.createButton);
        Task_Recycler = findViewById(R.id.recyclerView);
        Task_Recycler.setAdapter(adapter);
        Task_Recycler.setLayoutManager(new LinearLayoutManager(this));
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (text.length() == 0) {
                    Snackbar.make(findViewById(R.id.main_layout), "Try Writing an Actual Task!",
                            Snackbar.LENGTH_LONG).show();
                    return;
                } else {
                    tasks.add(new ToDo(text));
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }

            }


        });


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        outState.putInt("Size",tasks.size());
        for (int i = 0;i<tasks.size();i++)
        {
            String taskText ="Task " + i;
            String boolText = "Done "+ i;
            outState.putString(taskText,tasks.get(i).text);
            outState.putBoolean(boolText,tasks.get(i).Done); ;
        }
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int size = savedInstanceState.getInt("Size");
        for (int i=0;i<size;i++)
        {
            String taskText ="Task " + i;
            String boolText = "Done " + i;
            ToDo task = new ToDo(savedInstanceState.getString(taskText),savedInstanceState.getBoolean(boolText));
            tasks.add(task);
        }
    }
}

