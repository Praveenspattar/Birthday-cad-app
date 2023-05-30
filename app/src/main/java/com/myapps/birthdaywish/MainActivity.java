package com.myapps.birthdaywish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.myapps.birthdaywish.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //View Binding
    ActivityMainBinding binding;
    String input = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //next = findViewById(R.id.next);
        //text = findViewById(R.id.text);

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = binding.nameInput.getText().toString();
                if (!input.equals("")) {
                    Intent intent = new Intent(MainActivity.this, WishingScreen.class);
                    intent.putExtra("Name", input);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"Please enter your name",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}