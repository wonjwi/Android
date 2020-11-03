package com.cookandroid.minicalc02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText    edit1, edit2;
    Button      btnPlus, btnMinus, btnMul, btnDiv, btnRem;
    TextView    textResult;
    String      num1, num2;
    //실수값으로 계산하기 위해서 Double로 선언
    Double      result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //타이틀에 제목을 입력한다.
        setTitle("간단한 계산기");

        //계산처리를 위해서 입력 받은 값을 변수에 저장한다.
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        //계산처리를 위해서 어떤 Resource인지 알아낸다.
        btnPlus = (Button) findViewById(R.id.BtnPlus);
        btnMinus = (Button) findViewById(R.id.BtnMinus);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRem = (Button) findViewById(R.id.BtnRem);

        //처리결과를 보여주기 위해서 어떤 Resource인지 알아낸다.
        textResult = (TextView) findViewById(R.id.TextResult);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면에서 입력한 값을 변수에 저장한다.
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //입력된 값이 없으면 오류메시지를 나타낸다.
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "값을 모두 입력하세요", Toast.LENGTH_SHORT).show();

                } else { //값이 있으면 계산한 결과를 result에 저장한다.
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + String.format("%.3f", result));
                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면에서 입력한 값을 변수에 저장한다.
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //입력된 값이 없으면 오류메시지를 나타낸다.
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 모두 입력하세요", Toast.LENGTH_SHORT).show();

                } else { //값이 있으면 계산한 결과를 result에 저장한다.
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + String.format("%.3f", result));
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면에서 입력한 값을 변수에 저장한다.
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //입력된 값이 없으면 오류메시지를 나타낸다.
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "값을 모두 입력하세요", Toast.LENGTH_SHORT).show();

                } else { //값이 있으면 계산한 결과를 result에 저장한다.
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + String.format("%.3f", result));
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면에서 입력한 값을 변수에 저장한다.
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //입력된 값이 없으면 오류메시지를 나타낸다.
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "값을 모두 입력하세요", Toast.LENGTH_SHORT).show();

                //나누는 숫자가 0이면 오류메시지를 나타낸다.
                } else if(Double.parseDouble(num2.trim()) == 0) {
                    Toast.makeText(getApplicationContext(),
                            "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();

                } else { //값이 있으면 계산한 결과를 result에 저장한다.
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + String.format("%.3f", result));
                }
            }
        });

        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면에서 입력한 값을 변수에 저장한다.
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //입력된 값이 없으면 오류메시지를 나타낸다.
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "값을 모두 입력하세요", Toast.LENGTH_SHORT).show();

                //나누는 숫자가 0이면 오류메시지를 나타낸다.
                } else if(Double.parseDouble(num2.trim()) == 0) {
                    Toast.makeText(getApplicationContext(),
                            "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();

                } else { //값이 있으면 계산한 결과를 result에 저장한다.
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    textResult.setText("계산 결과 : " + String.format("%.3f", result));
                }
            }
        });

    }
}