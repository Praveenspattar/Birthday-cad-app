package com.myapps.birthdaywish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button next;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next.findViewById(R.id.next);
        text.findViewById(R.id.text);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("hello pavi");
            }
        });
    }
}