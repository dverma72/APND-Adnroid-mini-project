package com.example.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_home);

        Intent intent =getIntent();
        TextView user_name=findViewById(R.id.user_name);
        user_name.setText(intent.getStringExtra("user_name"));
    }
}
