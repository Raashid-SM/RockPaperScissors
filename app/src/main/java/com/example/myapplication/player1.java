package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class player1 extends AppCompatActivity {
    Button b_rock, b_paper, b_scissors,btn_start1,btn_next;
    EditText et_rounds;
    TextView tv_score,tv_rounds, tv_game,tv_result,tv_humanChoice,tv_computerChoice,tv_end;
    ImageView iv_ComputerChoice, iv_HumanChoice;
    int HumanScore, ComputerScore =0;
    int n;
    int i =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player1);

        b_paper=(Button) findViewById(R.id.b_paper);
        b_rock=(Button) findViewById(R.id.b_rock);
        b_scissors=(Button) findViewById(R.id.b_scissors);
        btn_start1=(Button)findViewById(R.id.btn_start1);
        btn_next=(Button) findViewById(R.id.btn_next);

        iv_ComputerChoice=(ImageView) findViewById((R.id.iv_ComputerChoice));
        iv_HumanChoice=(ImageView) findViewById(R.id.iv_HumanChoice);

        tv_score=(TextView) findViewById(R.id.tv_score);
        tv_game=(TextView) findViewById(R.id.tv_game);
        tv_result=(TextView) findViewById(R.id.tv_result);
        tv_rounds=(TextView) findViewById(R.id.tv_rounds);
        tv_computerChoice=(TextView) findViewById(R.id.tv_computerChoice) ;
        tv_humanChoice=(TextView) findViewById(R.id.tv_humanChoice);
        tv_end=(TextView) findViewById(R.id.tv_end);

        et_rounds=(EditText) findViewById(R.id.et_rounds);

        btn_start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=Integer.valueOf(et_rounds.getText().toString());

                et_rounds.setVisibility(View.INVISIBLE);
                tv_rounds.setVisibility(View.INVISIBLE);
                btn_start1.setVisibility(View.INVISIBLE);

                tv_humanChoice.setVisibility(View.VISIBLE);
                tv_computerChoice.setVisibility(View.VISIBLE);
                iv_HumanChoice.setVisibility(View.VISIBLE);
                iv_ComputerChoice.setVisibility(View.VISIBLE);
                tv_score.setVisibility(View.VISIBLE);
                b_paper.setVisibility(View.VISIBLE);
                b_rock.setVisibility(View.VISIBLE);
                b_scissors.setVisibility(View.VISIBLE);

            }
        });


        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                iv_HumanChoice.setImageResource(R.drawable.scissors);
                String message= play_turn("scissors");
                tv_game.setVisibility(View.VISIBLE);
                tv_game.setText("Round "+(i)+" results: " + (message));
                tv_score.setText("Score You: "+ Integer.toString(HumanScore)+ "     Computer: "+ Integer.toString(ComputerScore));
                if(i>=n){
                    b_paper.setVisibility(View.INVISIBLE);
                    b_rock.setVisibility(View.INVISIBLE);
                    b_scissors.setVisibility(View.INVISIBLE);
                    tv_end.setVisibility(View.VISIBLE);
                    tv_end.setText("click to check result");

                    btn_next.setVisibility(View.VISIBLE);

                }

            }
        });
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String message= play_turn("rock");
                tv_game.setVisibility(View.VISIBLE);
                tv_game.setText("Round "+(i)+" results: " + (message));
                tv_score.setText("Score You: "+ Integer.toString(HumanScore)+ "     Computer: "+ Integer.toString(ComputerScore));
                if (i >= n) {
                    b_paper.setVisibility(View.INVISIBLE);
                    b_rock.setVisibility(View.INVISIBLE);
                    b_scissors.setVisibility(View.INVISIBLE);
                    tv_end.setVisibility(View.VISIBLE);
                    tv_end.setText("click to check result");


                    btn_next.setVisibility(View.VISIBLE);
                }

            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                iv_HumanChoice.setImageResource(R.drawable.paper);
                String message= play_turn("paper");
                tv_game.setVisibility(View.VISIBLE);
                tv_game.setText("Round "+(i)+" results: " + (message));
                tv_score.setText("Score You: "+ Integer.toString(HumanScore)+ "     Computer: "+ Integer.toString(ComputerScore));
                if(i>=n) {
                    b_paper.setVisibility(View.INVISIBLE);
                    b_rock.setVisibility(View.INVISIBLE);
                    b_scissors.setVisibility(View.INVISIBLE);
                    tv_end.setVisibility(View.VISIBLE);
                    tv_end.setText("click to check result");

                    btn_next.setVisibility(View.VISIBLE);
                }
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ComputerScore==HumanScore){
                    opendraw();
                }
                else if (HumanScore>ComputerScore){
                    openwin();
                }
                else {
                    openlose();
                }
            }
        });

    }
    public String play_turn(String player_choice){
        String computer_choice="";
        Random r = new Random();
        int computer_choice_number = r.nextInt(3) + 1;

        if (computer_choice_number == 1){
            computer_choice="rock";
        }
        else if (computer_choice_number == 2){
            computer_choice="paper";
        }
        else if (computer_choice_number == 3){
            computer_choice="scissors";
        }

        if (computer_choice == "rock"){
            iv_ComputerChoice.setImageResource(R.drawable.rock);
        }else
        if (computer_choice == "paper") {
            iv_ComputerChoice.setImageResource(R.drawable.paper);
        }else
        if (computer_choice == "scissors") {
            iv_ComputerChoice.setImageResource(R.drawable.scissors);
        }



        if (computer_choice == player_choice){
            return "Draw, Noboody wins the round!";
        }
        else if (player_choice == "rock" && computer_choice =="scissors"){
            HumanScore++;
            return "Rock crushes Scissors, You win!";
        }
        else if (player_choice == "paper" && computer_choice =="rock") {
            HumanScore++;
            return "Paper covers Rock, You win!";
        }
        else if (player_choice == "scissors" && computer_choice =="paper") {
            HumanScore++;
            return "Scissors cuts Paper, You win!";
        }
        else if (computer_choice == "rock" && player_choice=="scissors"){
            ComputerScore++;
            return "Rock crushes Scisssors, You lose!";
        }
        else if (computer_choice == "paper" && player_choice=="rock"){
            ComputerScore++;
            return "Paper covers Rock, You lose!";
        }
        else if (computer_choice == "scissors" && player_choice=="paper"){
            ComputerScore++;
            return "Scissors cuts paper, You lose!";
        }
        else return "Not sure";

    }
    public void openwin(){
        Intent intent= new Intent(this,win.class);
        startActivity(intent);

    }

    public void opendraw(){
        Intent intent = new Intent(this,draw.class);
        startActivity(intent);
    }

    public void openlose(){
        Intent intent = new Intent (this,lose.class);
        startActivity(intent);
    }

}

