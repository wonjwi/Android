package com.cookandroid.sdcard02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Make Dir, Remove Dir");

        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        Button btnMakeDir, btnRemoveDir;
        btnMakeDir = (Button) findViewById(R.id.btnMakeDir);
        btnRemoveDir = (Button) findViewById(R.id.btnRemoveDir);

        //시스템에서 사용하는 ExternalStorage가 저장되는 위치를 알아낸다.
        final String strSDpath
                = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File myDir = new File(strSDpath + "/mydir");

        btnMakeDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.mkdir();
            }
        });
        btnRemoveDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
            }
        });
    } //End - protected void onCreate

} //End - public class MainActivity
