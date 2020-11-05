package com.cookandroid.project7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    //전역변수
    LinearLayout baseLayout;
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("컨텍스트 메뉴 이용");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
        registerForContextMenu(button1);
        button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);

        //설정을 원래대로 돌리는 버튼 추가
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                baseLayout.setBackgroundColor(Color.WHITE);
                button2.setRotation(0);
                button2.setScaleX(1);
                button2.setScaleY(1);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if (v == button1) {
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu1, menu);
        }
        if (v == button2) {
            menu.setHeaderTitle("버튼 변경");
            mInflater.inflate(R.menu.menu2, menu);
        }
    } //End - public void onCreateContextMenu

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRed:
                baseLayout.setBackgroundColor(Color.rgb(255, 70, 70));
                return true;
            case R.id.itemGreen:
                baseLayout.setBackgroundColor(Color.rgb(70, 255, 70));
                return true;
            case R.id.itemBlue:
                baseLayout.setBackgroundColor(Color.rgb(70, 70, 255));
                return true;
            case R.id.subRotate:
                button2.setRotation(45);
                return true;
            case R.id.subSize:
                button2.setScaleX(2);
                button2.setScaleY(2);
                return true;
        }
        return false;
    } //End - public boolean onContextItemSelected

} //End - public class MainActivity