package com.example.testdbconnect;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Button manBtn =  findViewById((R.id.man));

        manBtn.setOnClickListener(v->{
            Intent MaIntent = new Intent(InfoActivity.this, MainActivity.class);
            startActivity(MaIntent);

        });
    }
}