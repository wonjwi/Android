package com.cookandroid.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox checkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("동물 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        checkAgree = (CheckBox) findViewById(R.id.CheckAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        rdoCat = (RadioButton) findViewById(R.id.RdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);

        btnOK = (Button) findViewById(R.id.BtnOK);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        //체크박스의 체크상태가 변경 되면 실행
        checkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //체크를 하면 숨겨져 있던 것들을 보이게 함
                if(checkAgree.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);
                    rGroup1.clearCheck(); //선택을 지움
                    imgPet.setImageResource(0); //이미지 리소스를 없앰
                }
            }
        });

        //선택 버튼이 눌렸을 경우 실행
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rGroup1.getCheckedRadioButtonId()) {
                case R.id.RdoDog:
                    imgPet.setImageResource(R.drawable.dog2);
                    break;
                case R.id.RdoCat:
                    imgPet.setImageResource(R.drawable.cat);
                    break;
                case R.id.RdoRabbit:
                    imgPet.setImageResource(R.drawable.rabbit);
                    break;
                default:
                    Toast.makeText(getApplicationContext(),
                            "동물을 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
