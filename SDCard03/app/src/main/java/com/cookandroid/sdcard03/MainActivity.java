package com.cookandroid.sdcard03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("파일 목록 보기");

        Button btnFileList;
        final EditText edtFileList;
        btnFileList = (Button) findViewById(R.id.btnFileList);
        edtFileList = (EditText) findViewById(R.id.edtFileList);

        btnFileList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sysDir = Environment.getRootDirectory().getAbsolutePath();
                String sysDirSub;
                File[] sysFiles = (new File(sysDir).listFiles());
                File[] sysFilesSub;

                String strFname, strFname2;
                for(int i = 0; i < sysFiles.length; i++) {
                    //찾은 값이 디렉토리라면
                    if (sysFiles[i].isDirectory() == true) {
                        strFname = "<폴더> " + sysFiles[i].toString();
                        edtFileList.setText(edtFileList.getText() + "\n" + strFname);

                        //읽을 수 있는 디렉토리라면 한 번 더 탐색
                        if(sysFiles[i].canRead()) {
                            sysDirSub = sysFiles[i].getAbsolutePath();
                            sysFilesSub = (new File(sysDirSub).listFiles());
                            for(int j = 0; j < sysFilesSub.length; j++) {
                                strFname2 = "<서브> " + sysFilesSub[j].toString();
                                edtFileList.setText(edtFileList.getText() + "\n" + strFname2);
                            }
                        }

                    } else { //찾은 값이 파일이라면
                        strFname = "<파일> " + sysFiles[i].toString();
                        edtFileList.setText(edtFileList.getText() + "\n" + strFname);
                    }
                    /*
                    if(edtFileList.getText().toString().isEmpty()) {
                        edtFileList.setText(strFname);
                    } else {
                        edtFileList.setText(edtFileList.getText() + "\n" + strFname);
                    }
                     */
                }
            }
        });
    }
}
