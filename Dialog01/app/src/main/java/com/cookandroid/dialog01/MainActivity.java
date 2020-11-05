package com.cookandroid.dialog01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("대화상자");

        final Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //현재 내부 클래스 안이므로 '액티비티명.this'로 컨텍스트를 지정
                AlertDialog.Builder dlg
                        = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("대화상자");
                dlg.setMessage("이곳은 내용입니다.");
                dlg.setIcon(R.mipmap.ic_launcher);
                //대화상자에 확인 버튼 만들기
                //dlg.setPositiveButton("확인", null);
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,
                                        "확인 버튼을 눌렀습니다.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show();
                /*
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("제목입니다.")
                        .setMessage("내용입니다.")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("확인", null)
                        .show();
                 */
            }
        });
    }
}
