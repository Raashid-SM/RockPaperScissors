package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_start,btn_player1,btn_player2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button)findViewById(R.id.btn_start);
        btn_player1= (Button)findViewById(R.id.btn_player1);
        btn_player2 = (Button)findViewById(R.id.btn_player2);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_start.setVisibility(View.INVISIBLE);
                btn_player1.setVisibility(View.VISIBLE);
                btn_player2.setVisibility(View.VISIBLE);
            }
        });

        btn_player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openplayer1();
            }
        });
        btn_player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openplayer2();
            }
        });
    }

    public void openplayer1(){
        Intent intent = new Intent(this,player1.class);
        startActivity(intent);
    }
    public void openplayer2(){
        Intent intent = new Intent(this,player2.class);
        startActivity(intent);
    }
}
