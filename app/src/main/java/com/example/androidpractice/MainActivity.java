package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int cnt=0;
    int t1, t2, t3;
    LinearLayout ll_ans;
    EditText v1,v2,v3;
    Button bt_game;
    TextView tv_res;

    private void restart() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View 연결
        bt_game = findViewById(R.id.bt_game);
        tv_res = findViewById(R.id.tv_res);

        // 랜덤 숫자 3개 생성하기
        // Math.random()은 0이상 1미만 사이의 수를 출력한다.
        int value1 = (int)((Math.random()*9)+1);
        int value2 = (int)((Math.random()*9)+1);
        int value3 = (int)((Math.random()*9)+1);

        // 중복을 막기 위함
        while (value2==value1)
            value2 = (int)((Math.random()*9)+1);

        while (value3==value1 || value3==value2)
            value3 = (int)((Math.random()*9)+1);

        int fv1 = value1;
        int fv2 = value2;
        int fv3 = value3;

        // 게임 버튼을 눌렀을 때때
        bt_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v1 = findViewById(R.id.v1);
                v2 = findViewById(R.id.v2);
                v3 = findViewById(R.id.v3);
                ll_ans = findViewById(R.id.ll_ans); // 이거 안 써서 버그 났음.

                t1 = Integer.parseInt(v1.getText().toString());
                t2 = Integer.parseInt(v2.getText().toString());
                t3 = Integer.parseInt(v3.getText().toString());

                int strike=0;
                int ball=0;

                if(t1==fv1)
                    strike++;
                else if(t1==fv2 || t1==fv3)
                    ball++;

                if(t2==fv2)
                    strike++;
                else if(t2==fv1 || t2==fv3)
                    ball++;

                if(t3==fv3)
                    strike++;
                else if(t3==fv1 || t3==fv2)
                    ball++;


                if(strike==3) {
                    tv_res.append("맞아요! \n");
                    ll_ans.setVisibility(View.GONE); // 답안란 치워버리기 (버튼에는 적용x)
                    bt_game.setText("게임을 다시 시작하시겠습니까?");
                    bt_game.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            restart();
                        }
                    });
                }
                else
                    tv_res.append((cnt+1)+"번째 시도: "+"("+t1+", "+t2+", "+t3+") "+strike+"S "+ball+"B \n");
                cnt++;

                if(cnt==10 && strike!=3) {
                    tv_res.append("\n\n 답을 맞추지 못했습니다. 기회는 총 10번입니다.");
                    ll_ans.setVisibility(View.GONE); // 답안란 치워버리기 (버튼에는 적용x)
                    bt_game.setText("게임을 다시 시작하시겠습니까?");
                    bt_game.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            restart();
                        }
                    });
                }
            }
        });
    }

}