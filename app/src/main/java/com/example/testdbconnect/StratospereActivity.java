package com.example.testdbconnect;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StratospereActivity extends AppCompatActivity {

    private String url = "jdbc:postgresql://dpg-chpo7lqk728ivvp2sdm0-a.frankfurt-postgres.render.com/testdb_8mvz";
    private final String user = "user001";
    private final String pass = "8fHaiwS6echZdthcKdJI2B2vTWvMmF5q";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stratospere);

        TextView textop = this.findViewById(R.id.textop);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                    Connection connection = DriverManager.getConnection(url, user, pass);
//                    Connection connection = DriverManager.getConnection("jdbc:postgres://user001:8fHaiwS6echZdthcKdJI2B2vTWvMmF5q@dpg-chpo7lqk728ivvp2sdm0-a.frankfurt-postgres.render.com/testdb_8mvz");
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery("SELECT layer_type,dt,layer_value FROM layer_data WHERE layer_type='statosvere'");
                    String result = "";
                    while(rs.next()){
                        result+=rs.getDate(2).toString()+": "+rs.getBigDecimal(3).toString()+"\n";
                    }
                    textop.setText(result);
                }
                catch (Exception e)
                {
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try
        {
            thread.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Button minBtn =  findViewById((R.id.min));

        minBtn.setOnClickListener(v->{
            Intent MaIntent = new Intent(StratospereActivity.this, MainActivity.class);
            startActivity(MaIntent);

        });
    }
}