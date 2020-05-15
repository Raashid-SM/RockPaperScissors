package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class win extends AppCompatActivity {

    Button btn_restartGame, btn_mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        btn_restartGame=(Button)findViewById(R.id.btn_restartGame);
        btn_mainMenu=(Button) findViewById(R.id.btn_newgame);

        btn_restartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleGame();
            }
        });
        btn_mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenu();
            }
        });
    }
    public void singleGame(){
        Intent intent = new Intent(this,player1.class);
        startActivity(intent);
    }
    public void mainMenu(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
