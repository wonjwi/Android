package com.cookandroid.toastmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("토스트 메시지 연습");

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //기존 방식은 토스트 메시지가 정해진 위치에 나타난다.
                //Toast.makeText(getApplicationContext(), "토스트 연습입니다", Toast.LENGTH_SHORT).show();

                //토스트 메시지를 랜덤한 위치에 나타낸다.
                Toast tMsg = Toast.makeText(MainActivity.this,
                        "토스트 연습입니다", Toast.LENGTH_SHORT);
                Display display = ((WindowManager)
                        getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                //랜덤값 * 화면의 크기 => 화면의 크기보다 값이 클 수 없다.
                int xOffset = (int) (Math.random() * display.getWidth());
                int yOffset = (int) (Math.random() * display.getHeight());

                tMsg.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                tMsg.show();
            }
        });
    }
}
