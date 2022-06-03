package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Invisible extends AppCompatActivity {

    // 1. 변수 설정하기
    LinearLayout ll_test;
    ImageView iv_test;
    TextView tv_test;
    Button bt_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invisible);

        // 2. 뷰랑 연결하기
        ll_test = findViewById(R.id.ll_test);
        iv_test = findViewById(R.id.iv_bird);
        tv_test = findViewById(R.id.tv_test);
        bt_test = findViewById(R.id.bt_test);


        // 3. Disapepar 버튼을 눌렀을 때
        bt_test.setOnClickListener(new View.OnClickListener() {
            int visible = 1; // ll_test 보인다=1, 안보인다=0 으로 설정
            @Override
            public void onClick(View v) {
                if(visible==1){
                    ll_test.setVisibility(View.GONE); // INVISIBLE: 빈 공간이 생김, GONE: 공간까지 다 날아감
                    bt_test.setText("Appear!");
                    visible=0;
                } else{ // 5. Appear 버튼을 눌렀을 때
                    ll_test.setVisibility(View.VISIBLE);
                    bt_test.setText("Disappear");
                    visible=1;
                }


            }
        });

    }
}