package com.example.swimmingpool_rs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);

        Button save = findViewById(R.id.editProfile);
        save.setOnClickListener(view -> {
            Intent intent = new Intent(this, ProfileFragment.class);
            startActivity(intent);
        });

    }
}