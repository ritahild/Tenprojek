package com.example.testdbconnect;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.*;

public class MainActivity extends AppCompatActivity {
//    private String url = "jdbc:postgresql://10.0.2.2:5432/supply";
//    private final String user = "postgres";
//    private final String pass = "123456";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button StratosphereLayerBtn =  findViewById((R.id.StratosphereLayer));

        StratosphereLayerBtn.setOnClickListener(v->{
            Intent MaIntent = new Intent(MainActivity.this, StratospereActivity.class);
            startActivity(MaIntent);

        });
        Button TroposphereLayerBtn  =  findViewById((R.id.TroposphereLayer));

        TroposphereLayerBtn.setOnClickListener(v->{
            Intent MaIntent = new Intent(MainActivity.this, TroposhereActivity.class);
            startActivity(MaIntent);

        });
        Button  OzoneLayerBtn =  findViewById((R.id.OzoneLayer));

        OzoneLayerBtn.setOnClickListener(v->{
            Intent MaIntent = new Intent(MainActivity.this, OzonLayerActivity.class);
            startActivity(MaIntent);

        });
        Button InfoBtn =  findViewById((R.id.inf));

        InfoBtn.setOnClickListener(v->{
            Intent MaIntent = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(MaIntent);

        });





    }
}