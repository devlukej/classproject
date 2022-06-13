package com.example.teamproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StretchActivity extends AppCompatActivity {

    private static final int TOTAL = 5 * 1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;

    private int count = 5;
    private TextView countTxt, txt1 , txt2 ,txt3, txt4;
    private CountDownTimer countDownTimer;
    private ImageView imgView;
    private Button btnBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stretch);

        Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        btnBack = findViewById(R.id.BtnBack);
        imgView = findViewById(R.id.imageView);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        countTxt = findViewById(R.id.StartCnt);
        countDownTimer();
        countDownTimer.start();

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        /////////////////////////////////첫번째////////////////////////////////////////////

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgView.setImageResource(R.drawable.strca);
                txt2.setVisibility(View.VISIBLE);
                txt3.setVisibility(View.VISIBLE);
                txt4.setVisibility(View.VISIBLE);
                txt2.setText("흉쇄유돌근에 손을 올린 후");
                txt3.setText("고개와 턱을 아래로 내립니다");
                txt4.setText("( 5초간 3회 동작 유지 )");


                countDownTimer = new CountDownTimer(6000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);


                countDownTimer = new CountDownTimer(5200, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 13000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);

                countDownTimer = new CountDownTimer(5100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt2.setVisibility(View.INVISIBLE);
                        txt3.setVisibility(View.INVISIBLE);
                        txt4.setVisibility(View.INVISIBLE);
                        txt1.setText("다음 자세 준비");
                        vib.vibrate(1000);
                        imgView.setImageResource(R.drawable.strcb);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 20200);

        /////////////////////////////////두번째////////////////////////////////////////////


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                txt1.setVisibility(View.GONE);
                countTxt.setVisibility(View.VISIBLE);
                txt2.setVisibility(View.VISIBLE);
                txt3.setVisibility(View.VISIBLE);
                txt4.setVisibility(View.VISIBLE);
                txt2.setText("천천히 귀 아래 근육과 어깨까지");
                txt3.setText("연결된 근육을 당겨줍니다.");
                txt4.setText("( 10초간 3회 동작 유지 )");


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 27300);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 39400);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt2.setVisibility(View.INVISIBLE);
                        txt3.setVisibility(View.INVISIBLE);
                        txt4.setVisibility(View.INVISIBLE);
                        txt1.setText("다음 자세 준비");
                        vib.vibrate(1000);
                        imgView.setImageResource(R.drawable.strcc);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 51500);


        /////////////////////////////////세번째////////////////////////////////////////////

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                txt1.setVisibility(View.GONE);
                countTxt.setVisibility(View.VISIBLE);
                txt2.setVisibility(View.VISIBLE);
                txt3.setVisibility(View.VISIBLE);
                txt4.setVisibility(View.VISIBLE);
                txt2.setText("목을 옆으로 당겨줄 때");
                txt3.setText("어깨가 따라 올라가지 않도록 합니다.");
                txt4.setText("( 10초간 3회 동작 유지 )");


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 63600);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 75700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt2.setVisibility(View.INVISIBLE);
                        txt3.setVisibility(View.INVISIBLE);
                        txt4.setVisibility(View.INVISIBLE);
                        txt1.setText("다음 자세 준비");
                        vib.vibrate(1000);
                        imgView.setImageResource(R.drawable.strcd);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 87800);


        /////////////////////////////////네번째////////////////////////////////////////////

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                txt1.setVisibility(View.GONE);
                countTxt.setVisibility(View.VISIBLE);
                txt2.setVisibility(View.VISIBLE);
                txt3.setVisibility(View.VISIBLE);
                txt4.setVisibility(View.VISIBLE);
                txt2.setText("귀 아래쪽 근육과 팔을");
                txt3.setText("어깨 높이까지 벌려 충분히 당겨 줍니다.");
                txt4.setText("( 10초간 3회 동작 유지 )");


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 99900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 112000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt2.setVisibility(View.INVISIBLE);
                        txt3.setVisibility(View.INVISIBLE);
                        txt4.setVisibility(View.INVISIBLE);
                        txt1.setText("다음 자세 준비");
                        vib.vibrate(1000);
                        imgView.setImageResource(R.drawable.strce);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 124100);


        /////////////////////////////////다섯번째////////////////////////////////////////////

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                txt1.setVisibility(View.GONE);
                countTxt.setVisibility(View.VISIBLE);
                txt2.setVisibility(View.VISIBLE);
                txt3.setVisibility(View.VISIBLE);
                txt4.setVisibility(View.VISIBLE);
                txt2.setText("척추를 곧게 편 후");
                txt3.setText("턱을 뒤로 밀어줍니다.");
                txt4.setText("( 5초간 3회 동작 유지 )");



                countDownTimer = new CountDownTimer(5100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 136200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);


                countDownTimer = new CountDownTimer(5100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 143300);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);


                countDownTimer = new CountDownTimer(5100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt2.setVisibility(View.INVISIBLE);
                        txt3.setVisibility(View.INVISIBLE);
                        txt4.setVisibility(View.INVISIBLE);
                        txt1.setText("다음 자세 준비");
                        vib.vibrate(1000);
                        imgView.setImageResource(R.drawable.strcf);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 150400);

        /////////////////////////////////여섯번째////////////////////////////////////////////

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                txt1.setVisibility(View.GONE);
                countTxt.setVisibility(View.VISIBLE);
                txt2.setVisibility(View.VISIBLE);
                txt3.setVisibility(View.VISIBLE);
                txt4.setVisibility(View.VISIBLE);
                txt2.setText("목이 뒤로 가도록 힘을 준 후 ");
                txt3.setText("양손을 앞으로 향하도록 합니다.");
                txt4.setText("( 10초간 3회 동작 유지 )");


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 157500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("원위치 후 다시");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 169600);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                countTxt.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.GONE);


                countDownTimer = new CountDownTimer(10100, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        countTxt.setText(millisUntilFinished / 1000 + "초");
                    }

                    @Override
                    public void onFinish() {
                        countTxt.setVisibility(View.INVISIBLE);
                        imgView.setVisibility(View.INVISIBLE);
                        txt2.setVisibility(View.INVISIBLE);
                        txt3.setVisibility(View.INVISIBLE);
                        txt4.setVisibility(View.INVISIBLE);
                        txt1.setVisibility(View.VISIBLE);
                        txt1.setText("수고하셨습니다.");
                        vib.vibrate(1000);
                    } //종료 되었을 때 문자열을 보여줍니다
                }.start(); //카운트 시작

            }
        }, 181700);
    }

    public void countDownTimer() {
        countDownTimer = new CountDownTimer(TOTAL, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {
                countTxt.setText(String.valueOf(count));
                count--;


            }

            @Override
            public void onFinish() {
                txt1.setVisibility(View.GONE);
                //countTxt.setVisibility(View.INVISIBLE);

            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            countDownTimer.cancel();
        } catch (Exception e) {

        }

        countDownTimer = null;
    }
}
