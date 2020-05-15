package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class player2 extends AppCompatActivity {
    Button btn_next,btn_start1,btn_newgame,btn_nextRound,btn_rock,btn_rock2,btn_paper,btn_paper2,btn_scissors,btn_scissors2,btn_mainMenu;
    EditText et_player1, et_player2, et_rounds;
    TextView tv_score,tv_result,tv_playerPick,tv_resultRound,tv_name1,tv_name2,tv_rounds;
    ImageView iv_rock,iv_scissors,iv_paper;
    int player1Score, player2Score =0;
    int n;
    int i =0;
    String name1;
    String name2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2);
        btn_paper=(Button) findViewById(R.id.b_paper);
        btn_rock=(Button) findViewById(R.id.b_rock);
        btn_scissors=(Button) findViewById(R.id.b_scissors);
        btn_paper2=(Button) findViewById(R.id.b_paper2);
        btn_rock2=(Button) findViewById(R.id.b_rock2);
        btn_scissors2=(Button) findViewById(R.id.b_scissors2);
        btn_start1=(Button)findViewById(R.id.btn_start1);
        btn_newgame=(Button) findViewById(R.id.btn_newgame);
        btn_next=(Button) findViewById(R.id.btn_next);
        btn_nextRound=(Button)findViewById(R.id.btn_nextRound);
        btn_mainMenu=(Button)findViewById(R.id.btn_mainMenu);

        iv_rock=(ImageView) findViewById((R.id.iv_rock));
        iv_paper=(ImageView) findViewById(R.id.iv_paper);
        iv_scissors=(ImageView) findViewById(R.id.iv_scissors);

        tv_score=(TextView) findViewById(R.id.tv_score);
        tv_playerPick=(TextView) findViewById(R.id.tv_playerPick);
        tv_result=(TextView) findViewById(R.id.tv_result);
        tv_resultRound=(TextView) findViewById(R.id.tv_roundResult);
        tv_name1=(TextView) findViewById(R.id.tv_name1);
        tv_name2=(TextView) findViewById(R.id.tv_name2);
        tv_rounds=(TextView)findViewById(R.id.tv_rounds);


        et_rounds=(EditText) findViewById(R.id.et_rounds);
        et_player1=(EditText) findViewById(R.id.et_player1);
        et_player2=(EditText) findViewById(R.id.et_player2);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_next.setVisibility(View.INVISIBLE);
                tv_name1.setVisibility(View.INVISIBLE);
                tv_name2.setVisibility(View.INVISIBLE);
                et_player1.setVisibility(View.INVISIBLE);
                et_player2.setVisibility(View.INVISIBLE);

                tv_rounds.setVisibility(View.VISIBLE);
                et_rounds.setVisibility(View.VISIBLE);
                btn_start1.setVisibility(View.VISIBLE);
            }
        });

        btn_start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=Integer.valueOf(et_rounds.getText().toString());
                name1=et_player1.getText().toString();
                name2=et_player2.getText().toString();


                tv_rounds.setVisibility(View.INVISIBLE);
                et_rounds.setVisibility(View.INVISIBLE);
                btn_start1.setVisibility(View.INVISIBLE);

                tv_score.setVisibility(View.VISIBLE);
                tv_score.setText((name1)+": "+(player1Score)+"   "+(name2)+": "+(player2Score));
                tv_playerPick.setVisibility(View.VISIBLE);
                tv_playerPick.setText((name1)+"'s Turn");
                btn_paper.setVisibility(View.VISIBLE);
                btn_rock.setVisibility(View.VISIBLE);
                btn_scissors.setVisibility(View.VISIBLE);
                iv_paper.setVisibility(View.VISIBLE);
                iv_rock.setVisibility(View.VISIBLE);
                iv_scissors.setVisibility(View.VISIBLE);
            }
        });

        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_paper.setVisibility(View.INVISIBLE);
                btn_rock.setVisibility(View.INVISIBLE);
                btn_scissors.setVisibility(View.INVISIBLE);

                tv_playerPick.setText((name2)+"'s Turn");
                btn_paper2.setVisibility(View.VISIBLE);
                btn_rock2.setVisibility(View.VISIBLE);
                btn_scissors2.setVisibility(View.VISIBLE);
                iv_paper.setVisibility(View.VISIBLE);
                iv_rock.setVisibility(View.VISIBLE);
                iv_scissors.setVisibility(View.VISIBLE);

                btn_rock2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btn_paper2.setVisibility(View.INVISIBLE);
                        btn_rock2.setVisibility(View.INVISIBLE);
                        btn_scissors2.setVisibility(View.INVISIBLE);
                        iv_paper.setVisibility(View.INVISIBLE);
                        iv_rock.setVisibility(View.INVISIBLE);
                        iv_scissors.setVisibility(View.INVISIBLE);
                        tv_playerPick.setVisibility(View.INVISIBLE);

                        tv_resultRound.setVisibility(View.VISIBLE);
                        tv_score.setText((name1)+": "+(player1Score)+"   "+(name2)+": "+(player2Score));
                        tv_resultRound.setText("Both chose rock, it's a draw");
                        btn_nextRound.setVisibility(View.VISIBLE);

                        btn_nextRound.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i++;
                                if (i < n) {
                                    tv_resultRound.setVisibility(View.INVISIBLE);
                                    btn_nextRound.setVisibility(View.INVISIBLE);

                                    tv_score.setVisibility(View.VISIBLE);
                                    tv_playerPick.setVisibility(View.VISIBLE);
                                    tv_playerPick.setText((name1)+"''s Turn");
                                    btn_paper.setVisibility(View.VISIBLE);
                                    btn_rock.setVisibility(View.VISIBLE);
                                    btn_scissors.setVisibility(View.VISIBLE);
                                    iv_paper.setVisibility(View.VISIBLE);
                                    iv_rock.setVisibility(View.VISIBLE);
                                    iv_scissors.setVisibility(View.VISIBLE);
                                }
                                else if (i >= n) {
                                    if (player1Score == player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText("It is a draw");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player1Score > player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name1)+" wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player2Score > player1Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name2)+" wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        });
                    }
                });
                btn_paper2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player2Score++;
                        btn_paper2.setVisibility(View.INVISIBLE);
                        btn_rock2.setVisibility(View.INVISIBLE);
                        btn_scissors2.setVisibility(View.INVISIBLE);
                        iv_paper.setVisibility(View.INVISIBLE);
                        iv_rock.setVisibility(View.INVISIBLE);
                        iv_scissors.setVisibility(View.INVISIBLE);
                        tv_playerPick.setVisibility(View.INVISIBLE);

                        tv_resultRound.setVisibility(View.VISIBLE);
                        tv_resultRound.setText((name2)+"'s paper covers "+ (name1)+"'s rock");
                        tv_score.setText((name1)+": "+(player1Score)+"   "+(name2)+": "+(player2Score));
                        btn_nextRound.setVisibility(View.VISIBLE);

                        btn_nextRound.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i++;
                                if (i < n) {
                                    tv_resultRound.setVisibility(View.INVISIBLE);
                                    btn_nextRound.setVisibility(View.INVISIBLE);

                                    tv_score.setVisibility(View.VISIBLE);
                                    tv_playerPick.setVisibility(View.VISIBLE);
                                    tv_playerPick.setText((name1) + "'s Turn");
                                    btn_paper.setVisibility(View.VISIBLE);
                                    btn_rock.setVisibility(View.VISIBLE);
                                    btn_scissors.setVisibility(View.VISIBLE);
                                    iv_paper.setVisibility(View.VISIBLE);
                                    iv_rock.setVisibility(View.VISIBLE);
                                    iv_scissors.setVisibility(View.VISIBLE);
                                }
                                else if (i >= n) {
                                    if (player1Score == player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText("It is a draw");

                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player1Score > player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name1) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player2Score > player1Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name2) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        });
                    }
                });
                btn_scissors2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player1Score++;
                        btn_paper2.setVisibility(View.INVISIBLE);
                        btn_rock2.setVisibility(View.INVISIBLE);
                        btn_scissors2.setVisibility(View.INVISIBLE);
                        iv_paper.setVisibility(View.INVISIBLE);
                        iv_rock.setVisibility(View.INVISIBLE);
                        iv_scissors.setVisibility(View.INVISIBLE);
                        tv_playerPick.setVisibility(View.INVISIBLE);

                        tv_resultRound.setVisibility(View.VISIBLE);
                        tv_resultRound.setText((name1)+"'s rock crushes "+ (name2)+"'s scissors");
                        tv_score.setText((name1)+": "+(player1Score)+"   "+(name2)+": "+(player2Score));
                        btn_nextRound.setVisibility(View.VISIBLE);

                        btn_nextRound.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i++;
                                if (i < n) {
                                    tv_resultRound.setVisibility(View.INVISIBLE);
                                    btn_nextRound.setVisibility(View.INVISIBLE);

                                    tv_score.setVisibility(View.VISIBLE);
                                    tv_playerPick.setVisibility(View.VISIBLE);
                                    tv_playerPick.setText((name1) + "'s Turn");
                                    btn_paper.setVisibility(View.VISIBLE);
                                    btn_rock.setVisibility(View.VISIBLE);
                                    btn_scissors.setVisibility(View.VISIBLE);
                                    iv_paper.setVisibility(View.VISIBLE);
                                    iv_rock.setVisibility(View.VISIBLE);
                                    iv_scissors.setVisibility(View.VISIBLE);
                                }
                                else if (i >= n) {
                                    if (player1Score == player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText("It is a draw");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player1Score > player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name1) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player2Score > player1Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name2) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });
        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_paper.setVisibility(View.INVISIBLE);
                btn_rock.setVisibility(View.INVISIBLE);
                btn_scissors.setVisibility(View.INVISIBLE);

                tv_playerPick.setText((name2)+"s Turn");
                btn_paper2.setVisibility(View.VISIBLE);
                btn_rock2.setVisibility(View.VISIBLE);
                btn_scissors2.setVisibility(View.VISIBLE);
                iv_paper.setVisibility(View.VISIBLE);
                iv_rock.setVisibility(View.VISIBLE);
                iv_scissors.setVisibility(View.VISIBLE);

                btn_rock2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player2Score++;
                        btn_paper2.setVisibility(View.INVISIBLE);
                        btn_rock2.setVisibility(View.INVISIBLE);
                        btn_scissors2.setVisibility(View.INVISIBLE);
                        iv_paper.setVisibility(View.INVISIBLE);
                        iv_rock.setVisibility(View.INVISIBLE);
                        iv_scissors.setVisibility(View.INVISIBLE);
                        tv_playerPick.setVisibility(View.INVISIBLE);

                        tv_resultRound.setVisibility(View.VISIBLE);
                        tv_resultRound.setText((name2)+"'s rocks crushes "+(name1)+"'s scissors");
                        tv_score.setText((name1)+": "+(player1Score)+"   "+(name2)+": "+(player2Score));
                        btn_nextRound.setVisibility(View.VISIBLE);

                        btn_nextRound.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i++;
                                if (i < n) {
                                    tv_resultRound.setVisibility(View.INVISIBLE);
                                    btn_nextRound.setVisibility(View.INVISIBLE);

                                    tv_score.setVisibility(View.VISIBLE);
                                    tv_playerPick.setVisibility(View.VISIBLE);
                                    tv_playerPick.setText((name1)+"'s Turn");
                                    btn_paper.setVisibility(View.VISIBLE);
                                    btn_rock.setVisibility(View.VISIBLE);
                                    btn_scissors.setVisibility(View.VISIBLE);
                                    iv_paper.setVisibility(View.VISIBLE);
                                    iv_rock.setVisibility(View.VISIBLE);
                                    iv_scissors.setVisibility(View.VISIBLE);
                                }
                                else if (i >= n) {
                                    if (player1Score == player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText("It is a draw");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player1Score > player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name1)+" wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player2Score > player1Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name2)+" wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        });
                    }
                });
                btn_paper2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player1Score++;
                        btn_paper2.setVisibility(View.INVISIBLE);
                        btn_rock2.setVisibility(View.INVISIBLE);
                        btn_scissors2.setVisibility(View.INVISIBLE);
                        iv_paper.setVisibility(View.INVISIBLE);
                        iv_rock.setVisibility(View.INVISIBLE);
                        iv_scissors.setVisibility(View.INVISIBLE);
                        tv_playerPick.setVisibility(View.INVISIBLE);

                        tv_resultRound.setVisibility(View.VISIBLE);
                        tv_resultRound.setText((name1)+"'s scissors cuts "+ (name2)+"s paper");
                        tv_score.setText((name1)+": "+(player1Score)+"   "+(name2)+": "+(player2Score));
                        btn_nextRound.setVisibility(View.VISIBLE);

                        btn_nextRound.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i++;
                                if (i < n) {
                                    tv_resultRound.setVisibility(View.INVISIBLE);
                                    btn_nextRound.setVisibility(View.INVISIBLE);

                                    tv_score.setVisibility(View.VISIBLE);
                                    tv_playerPick.setVisibility(View.VISIBLE);
                                    tv_playerPick.setText((name1) + "'s Turn");
                                    btn_paper.setVisibility(View.VISIBLE);
                                    btn_rock.setVisibility(View.VISIBLE);
                                    btn_scissors.setVisibility(View.VISIBLE);
                                    iv_paper.setVisibility(View.VISIBLE);
                                    iv_rock.setVisibility(View.VISIBLE);
                                    iv_scissors.setVisibility(View.VISIBLE);
                                }
                                else if (i >= n) {
                                    if (player1Score == player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText("It is a draw");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player1Score > player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name1) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player2Score > player1Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name2) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        });
                    }
                });
                btn_scissors2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        btn_paper2.setVisibility(View.INVISIBLE);
                        btn_rock2.setVisibility(View.INVISIBLE);
                        btn_scissors2.setVisibility(View.INVISIBLE);
                        iv_paper.setVisibility(View.INVISIBLE);
                        iv_rock.setVisibility(View.INVISIBLE);
                        iv_scissors.setVisibility(View.INVISIBLE);
                        tv_playerPick.setVisibility(View.INVISIBLE);

                        tv_resultRound.setVisibility(View.VISIBLE);
                        tv_resultRound.setText("Both chose scissors, it's a draw");
                        tv_score.setText((name1)+": "+(player1Score)+"   "+(name2)+": "+(player2Score));
                        btn_nextRound.setVisibility(View.VISIBLE);

                        btn_nextRound.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i++;
                                if (i < n) {
                                    tv_resultRound.setVisibility(View.INVISIBLE);
                                    btn_nextRound.setVisibility(View.INVISIBLE);

                                    tv_score.setVisibility(View.VISIBLE);
                                    tv_playerPick.setVisibility(View.VISIBLE);
                                    tv_playerPick.setText((name1) + "'s Turn");
                                    btn_paper.setVisibility(View.VISIBLE);
                                    btn_rock.setVisibility(View.VISIBLE);
                                    btn_scissors.setVisibility(View.VISIBLE);
                                    iv_paper.setVisibility(View.VISIBLE);
                                    iv_rock.setVisibility(View.VISIBLE);
                                    iv_scissors.setVisibility(View.VISIBLE);
                                }
                                else if (i >= n) {
                                    if (player1Score == player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText("It is a draw");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player1Score > player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name1) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player2Score > player1Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name2) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });
        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_paper.setVisibility(View.INVISIBLE);
                btn_rock.setVisibility(View.INVISIBLE);
                btn_scissors.setVisibility(View.INVISIBLE);

                tv_playerPick.setText((name2)+"s Turn");
                btn_paper2.setVisibility(View.VISIBLE);
                btn_rock2.setVisibility(View.VISIBLE);
                btn_scissors2.setVisibility(View.VISIBLE);
                iv_paper.setVisibility(View.VISIBLE);
                iv_rock.setVisibility(View.VISIBLE);
                iv_scissors.setVisibility(View.VISIBLE);

                btn_rock2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        player1Score++;
                        btn_paper2.setVisibility(View.INVISIBLE);
                        btn_rock2.setVisibility(View.INVISIBLE);
                        btn_scissors2.setVisibility(View.INVISIBLE);
                        iv_paper.setVisibility(View.INVISIBLE);
                        iv_rock.setVisibility(View.INVISIBLE);
                        iv_scissors.setVisibility(View.INVISIBLE);
                        tv_playerPick.setVisibility(View.INVISIBLE);

                        tv_resultRound.setVisibility(View.VISIBLE);
                        tv_resultRound.setText((name1)+"'s paper covers "+(name2)+"'s rock");
                        tv_score.setText((name1)+": "+(player1Score)+"   "+(name2)+": "+(player2Score));
                        btn_nextRound.setVisibility(View.VISIBLE);

                        btn_nextRound.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i++;
                                if (i < n) {
                                    tv_resultRound.setVisibility(View.INVISIBLE);
                                    btn_nextRound.setVisibility(View.INVISIBLE);

                                    tv_score.setVisibility(View.VISIBLE);
                                    tv_playerPick.setVisibility(View.VISIBLE);
                                    tv_playerPick.setText((name1)+"'s Turn");
                                    btn_paper.setVisibility(View.VISIBLE);
                                    btn_rock.setVisibility(View.VISIBLE);
                                    btn_scissors.setVisibility(View.VISIBLE);
                                    iv_paper.setVisibility(View.VISIBLE);
                                    iv_rock.setVisibility(View.VISIBLE);
                                    iv_scissors.setVisibility(View.VISIBLE);
                                }
                                else if (i >= n) {
                                    if (player1Score == player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText("It is a draw");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player1Score > player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name1)+" wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player2Score > player1Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name2)+" wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        });
                    }
                });
                btn_paper2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        btn_paper2.setVisibility(View.INVISIBLE);
                        btn_rock2.setVisibility(View.INVISIBLE);
                        btn_scissors2.setVisibility(View.INVISIBLE);
                        iv_paper.setVisibility(View.INVISIBLE);
                        iv_rock.setVisibility(View.INVISIBLE);
                        iv_scissors.setVisibility(View.INVISIBLE);
                        tv_playerPick.setVisibility(View.INVISIBLE);

                        tv_resultRound.setVisibility(View.VISIBLE);
                        tv_resultRound.setText("Both chose paper,it's a draw");
                        tv_score.setText((name1)+": "+(player1Score)+"   "+(name2)+": "+(player2Score));
                        btn_nextRound.setVisibility(View.VISIBLE);

                        btn_nextRound.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i++;
                                if (i < n) {
                                    tv_resultRound.setVisibility(View.INVISIBLE);
                                    btn_nextRound.setVisibility(View.INVISIBLE);

                                    tv_score.setVisibility(View.VISIBLE);
                                    tv_playerPick.setVisibility(View.VISIBLE);
                                    tv_playerPick.setText((name1) + "'s Turn");
                                    btn_paper.setVisibility(View.VISIBLE);
                                    btn_rock.setVisibility(View.VISIBLE);
                                    btn_scissors.setVisibility(View.VISIBLE);
                                    iv_paper.setVisibility(View.VISIBLE);
                                    iv_rock.setVisibility(View.VISIBLE);
                                    iv_scissors.setVisibility(View.VISIBLE);
                                }
                                else if (i >= n) {
                                    if (player1Score == player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText("It is a draw");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player1Score > player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name1) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                    }
                                    else if (player2Score > player1Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name2) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        });
                    }
                });
                btn_scissors2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        player2Score++;
                        btn_paper2.setVisibility(View.INVISIBLE);
                        btn_rock2.setVisibility(View.INVISIBLE);
                        btn_scissors2.setVisibility(View.INVISIBLE);
                        iv_paper.setVisibility(View.INVISIBLE);
                        iv_rock.setVisibility(View.INVISIBLE);
                        iv_scissors.setVisibility(View.INVISIBLE);
                        tv_playerPick.setVisibility(View.INVISIBLE);

                        tv_resultRound.setVisibility(View.VISIBLE);
                        tv_resultRound.setText((name2)+"'s scissors cuts "+ (name1)+"'s paper");
                        tv_score.setText((name1)+": "+(player1Score)+"   "+(name2)+": "+(player2Score));
                        btn_nextRound.setVisibility(View.VISIBLE);

                        btn_nextRound.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                i++;
                                if (i < n) {
                                    tv_resultRound.setVisibility(View.INVISIBLE);
                                    btn_nextRound.setVisibility(View.INVISIBLE);

                                    tv_score.setVisibility(View.VISIBLE);
                                    tv_playerPick.setVisibility(View.VISIBLE);
                                    tv_playerPick.setText((name1) + "'s Turn");
                                    btn_paper.setVisibility(View.VISIBLE);
                                    btn_rock.setVisibility(View.VISIBLE);
                                    btn_scissors.setVisibility(View.VISIBLE);
                                    iv_paper.setVisibility(View.VISIBLE);
                                    iv_rock.setVisibility(View.VISIBLE);
                                    iv_scissors.setVisibility(View.VISIBLE);
                                }
                                else if (i >= n) {
                                    if (player1Score == player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText("It is a draw");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player1Score > player2Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name1) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                    else if (player2Score > player1Score) {
                                        tv_resultRound.setVisibility(View.INVISIBLE);
                                        btn_nextRound.setVisibility(View.INVISIBLE);

                                        tv_result.setVisibility(View.VISIBLE);
                                        tv_result.setText((name2) + " wins");
                                        btn_newgame.setVisibility(View.VISIBLE);
                                        btn_mainMenu.setVisibility(View.VISIBLE);
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });
        btn_newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=0;
                player2Score=0;
                player1Score=0;
                tv_result.setVisibility(View.INVISIBLE);
                btn_newgame.setVisibility(View.INVISIBLE);
                btn_mainMenu.setVisibility(View.INVISIBLE);

                tv_score.setVisibility(View.VISIBLE);
                tv_score.setText((name1)+": "+(player1Score)+"   "+(name2)+": "+(player2Score));
                tv_playerPick.setVisibility(View.VISIBLE);
                tv_playerPick.setText((name1)+"'s Turn");
                btn_paper.setVisibility(View.VISIBLE);
                btn_rock.setVisibility(View.VISIBLE);
                btn_scissors.setVisibility(View.VISIBLE);
                iv_paper.setVisibility(View.VISIBLE);
                iv_rock.setVisibility(View.VISIBLE);
                iv_scissors.setVisibility(View.VISIBLE);
            }
        });

        btn_mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainmenu();
            }
        });
    }
    public void mainmenu(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}





