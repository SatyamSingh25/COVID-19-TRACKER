package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void WorldData(View view){
        Intent i = new Intent(this, WorldData.class);
        startActivity(i);
    }
    public void IndianData(View view){
        Intent i = new Intent(this, IndianData.class);
        startActivity(i);
    }
    public void Statewise(View view){
        Intent i = new Intent(this, Statewise.class);
        startActivity(i);
    }
}