package com.example.convertorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BinaryToOther(View v) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void OctalToOther(View v){
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
    public void DecimalToOther(View v){
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);
    }

    public void HexaDecimalToOther(View v){
        Intent intent = new Intent(this,MainActivity5.class);
        startActivity(intent);
    }



}