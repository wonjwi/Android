package com.cookandroid.menuselectimage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //전역변수
    EditText    edtAngle;
    ImageView   imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");

        edtAngle = (EditText) findViewById(R.id.edtAngle);
        imageView1 = (ImageView) findViewById(R.id.imageView1);

    } //End - protected void onCreate

    //메뉴를 레이아웃으로 불러들인다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    //메뉴에서 아이템을 선택했을 때 작동되는 내용을 만든다.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemRotate:
                imageView1.setRotation(Float.parseFloat(edtAngle.getText().toString()));
                return true;
            case R.id.item1:
                imageView1.setImageResource(R.drawable.jeju1);
                item.setChecked(true);
                return true;
            case R.id.item2:
                imageView1.setImageResource(R.drawable.jeju2);
                item.setChecked(true);
                return true;
            case R.id.item3:
                imageView1.setImageResource(R.drawable.jeju3);
                item.setChecked(true);
                return true;
        }
        return false;
    }
} //End - public class MainActivity
