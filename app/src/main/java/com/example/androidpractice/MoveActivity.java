package com.example.androidpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MoveActivity extends AppCompatActivity {

    LinearLayout ll_move;
    ImageView iv_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        // View 연결
        ll_move = findViewById(R.id.ll_move);
        iv_move = findViewById(R.id.iv_move);

        // Step 1. 화면 전체에 터치 리스너 먹이기
//        ll_move.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN: // 터치 시작
//                    case MotionEvent.ACTION_MOVE: // 드래그
//                    case MotionEvent.ACTION_UP: // 터치 떼기
//                        // 좌표 지정
//                        iv_move.setX(event.getX());
//                        iv_move.setY(event.getY());
//                }
//                return true;
//            }
//        });

        iv_move.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN: // 터치 시작
                        // v.getX,Y() : ImageView가 화면 안에 있는 좌표=>이미지의 왼쪽 꼭짓점의 좌표임.
                        // event.getX,Y() : Imageview 안에서 마우스가 클릭하는 좌표
                        Toast.makeText(getApplicationContext(),
                                event.getX()+"/"+v.getX()
                                        +"\n"+event.getY()+"/"+v.getY(),
                                Toast.LENGTH_SHORT).show();
                    case MotionEvent.ACTION_MOVE: // 드래그
                    case MotionEvent.ACTION_UP: // 터치 떼기
                        iv_move.setX(v.getX()+event.getX()-v.getWidth()/2); // 그림 정가운데 잡아서 끌기
                        iv_move.setY(v.getY()+event.getY()-v.getHeight()/2);
                }

                return true;
            }
        });

    }
}