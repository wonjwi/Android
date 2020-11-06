package com.cookandroid.project8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //전역변수
    DatePicker  dp;
    EditText    edtDiary;
    Button      btnWrite;
    String      fileName; //일기 내용을 저장할 파일을 가리키는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("나만의 일기장");

        dp = (DatePicker) findViewById(R.id.datePicker1);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int cYear   = cal.get(Calendar.YEAR);
        int cMonth  = cal.get(Calendar.MONTH);
        int cDay    = cal.get(Calendar.DAY_OF_MONTH);

        //달력을 초기화한다.
        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //저장할 파일 이름 : yyyy_mm_dd
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });

        //글 작성 혹은 수정 버튼이 눌렸을 경우
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //일기 파일(yyyy_mm_dd.txt)을 쓰기모드로 연다.
                    FileOutputStream outFs
                            = openFileOutput(fileName, Context.MODE_PRIVATE);
                    //파일에 기록할 내용을 변수에 저장한다.
                    String str = edtDiary.getText().toString();
                    //파일에 저장한 변수의 내용을 기록한다.
                    outFs.write(str.getBytes());
                    outFs.close();

                    Toast.makeText(getApplicationContext(),
                            fileName + "이 저장되었습니다.",
                            Toast.LENGTH_SHORT).show();

                } catch (IOException e) {

                }
            }
        });
    } //End - protected void onCreate

    //선택된 날짜에 해당되는 파일의 내용을 읽어들인다.
    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;

        try {
            //선택한 날짜에 해당하는 파일이 존재하면 그 내용을 읽어들인다.
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];

            inFs.read(txt);
            inFs.close();
            //파일의 내용을 readDiary()를 요청한 곳에 넘겨줄 변수에 저장한다.
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정하기");
        } catch (IOException e) {
            edtDiary.setHint("일기가 없음");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    } //End - String readDiary(String fName)

} //End - public class MainActivity
