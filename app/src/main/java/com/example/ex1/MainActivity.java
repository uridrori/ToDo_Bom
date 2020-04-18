package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText newList;
    TextView existingList;
    Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newList = (EditText) findViewById(R.id.NewList);
        existingList = (TextView) findViewById(R.id.currList);
        editButton = (Button) findViewById(R.id.createButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                existingList.setText(newList.getText().toString());
                newList.setText("");
            }
        });
    }


}
