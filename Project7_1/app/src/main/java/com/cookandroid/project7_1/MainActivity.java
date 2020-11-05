package com.cookandroid.project7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    //전역변수
    LinearLayout baseLayout;
    Button       button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴 만들기 연습");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseLayout.setBackgroundColor(Color.WHITE);
                button1.setScaleX(1);
                button1.setScaleY(1);
                button1.setRotation(0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        /* XML 파일을 이용해서 menu를 구성한다.
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        */
        //자바 코드로 menu를 구성한다.
        menu.add(0, 1, 0, "배경색은 빨강");
        menu.add(0, 2, 0, "배경색은 초록");
        menu.add(0, 3, 0, "배경색은 파랑");

        SubMenu sMenu = menu.addSubMenu("버튼 변경");
        sMenu.add(0, 4, 0, "버튼 45도 회전");
        sMenu.add(0, 5, 0, "버튼 2배 확대");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
            case 1:
                baseLayout.setBackgroundColor(Color.rgb(255, 70, 70));
                return true;
            case R.id.itemGreen:
            case 2:
                baseLayout.setBackgroundColor(Color.rgb(70, 255, 70));
                return true;
            case R.id.itemBlue:
            case 3:
                baseLayout.setBackgroundColor(Color.rgb(70, 70, 255));
                return true;
            case R.id.subRotate:
            case 4:
                button1.setRotation(45);
                return true;
            case R.id.subSize:
            case 5:
                button1.setScaleX(2);
                button1.setScaleY(2);
                return true;
        }
        return false;
    }
}
