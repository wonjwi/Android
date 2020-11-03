package com.cookandroid.minicalc01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText    edit1, edit2;
    Button      btnPlus, btnMinus, btnMul, btnDiv;
    TextView    textResult;
    String      num1, num2;
    Integer     result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //타이틀에 제목을 입력한다.
        setTitle("매우 간단한 계산기");

        //계산처리를 위해서 입력 받은 값을 변수에 저장한다.
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        //계산처리를 위해서 어떤 Resource인지 알아낸다.
        btnPlus = (Button) findViewById(R.id.BtnPlus);
        btnMinus = (Button) findViewById(R.id.BtnMinus);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);

        //처리결과를 보여주기 위해서 어떤 Resource인지 알아낸다.
        textResult = (TextView) findViewById(R.id.TextResult);

        btnPlus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //화면에서 입력한 값을 변수에 저장한다.
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //계산한 결과를 result에 저장한다.
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnMinus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //화면에서 입력한 값을 변수에 저장한다.
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //계산한 결과를 result에 저장한다.
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //화면에서 입력한 값을 변수에 저장한다.
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //계산한 결과를 result에 저장한다.
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //화면에서 입력한 값을 변수에 저장한다.
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //계산한 결과를 result에 저장한다.
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
                return false;
            }
        });

    }
}
