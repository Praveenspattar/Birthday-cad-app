package com.myapps.birthdaywish;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.myapps.birthdaywish.databinding.ActivityWishingScreenBinding;

public class WishingScreen extends AppCompatActivity {

    //View Binding
    ActivityWishingScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWishingScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}