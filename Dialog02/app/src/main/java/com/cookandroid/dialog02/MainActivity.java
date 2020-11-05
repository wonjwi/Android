package com.cookandroid.dialog02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //멀티초이스의 경우 각 아이템의 선택상태를 가지고 있어야 한다.
    private boolean[] checkArray = new boolean[] {false, true, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("대화상자 2편");

        final Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //선택할 아이템의 종류를 배열에 저장한다.
                final String[] foodArray
                        = new String[] {"티라미수", "당근케이크", "치즈케이크"};
                //멀티초이스의 경우 각 아이템의 선택상태를 가지고 있어야 한다.
                //final boolean[] checkArray = new boolean[] {false, true, false};

                AlertDialog.Builder dlg
                        = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("내가 좋아하는 간식은?");
                dlg.setIcon(R.mipmap.ic_launcher);
                /*
                dlg.setSingleChoiceItems(foodArray, 1,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                button1.setText(foodArray[which]);
                            }
                        });
                 */
                dlg.setMultiChoiceItems(foodArray, checkArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkArray[which] = isChecked;
                                if(isChecked == true) {
                                    button1.setText(foodArray[which]);
                                }
                            }
                        });
                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });
    }
}
