package com.cookandroid.project8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    //전역변수
    Button          btnPrev, btnNext;
    myPictureView   myPicture;
    int             curNum; //현재 그림번호
    File[]          imageFiles;
    String          imageFname;
    TextView        tvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단한 그림 보기");

        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        //전역변수와 위젯을 연결
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);
        tvNumber = (TextView) findViewById(R.id.tvNumber);

        //이미지가 저장된 경로에서 파일들을 읽어들인다.
        imageFiles = new File(Environment.getExternalStorageDirectory().
                getAbsolutePath() + "/Pictures").listFiles();
        imageFname = imageFiles[0].toString();
        myPicture.imagePath = imageFname;
        myPicture.invalidate();
        tvNumber.setText((curNum+1) + " / " + imageFiles.length);

        //이전 그림 버튼을 눌렀을 경우
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum <= 0) {
                    Toast.makeText(getApplicationContext(),
                            "첫번째 그림입니다.", Toast.LENGTH_SHORT).show();
                } else {
                    imageFname = imageFiles[--curNum].toString();
                    myPicture.imagePath = imageFname;
                    //invalidate()를 호출하면 myPicture 클래스의 onDraw()가 호출된다.
                    myPicture.invalidate();
                    tvNumber.setText((curNum+1) + " / " + imageFiles.length);
                }
            }
        });

        //다음 그림 버튼을 눌렀을 경우
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum >= imageFiles.length-1) {
                    Toast.makeText(getApplicationContext(),
                            "마지막 그림입니다.", Toast.LENGTH_SHORT).show();
                } else {
                    imageFname = imageFiles[++curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    tvNumber.setText((curNum+1) + " / " + imageFiles.length);
                }
            }
        });

    } //End - protected void onCreate

} //End - public class MainActivity
