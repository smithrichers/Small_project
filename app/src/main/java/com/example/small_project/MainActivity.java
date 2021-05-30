package com.example.small_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView text1,text2,text3,text4,text5,text6,text7,text8,text9;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=findViewById(R.id.textview_1);
        text2=findViewById(R.id.textview_2);
        text3=findViewById(R.id.textview_3);
        text4=findViewById(R.id.textview_4);
        text5=findViewById(R.id.textview_5);
        text6=findViewById(R.id.textview_6);
        text7=findViewById(R.id.textview_7);
        text8=findViewById(R.id.textview_8);
        text9=findViewById(R.id.textview_9);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//textview_1界面
                Toast.makeText(MainActivity.this,"正在跳转至时钟页面",Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(MainActivity.this, Text_ClockActivity.class);
                        startActivity(intent);
                    }
                },2500); // 延时2.5秒
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://weathernew.pae.baidu.com/weathernew/pc?query=%E7%9B%90%E5%9F%8E%E5%A4%A9%E6%B0%94&srcid=4982&city_name=%E7%9B%90%E5%9F%8E&province_name=%E6%B1%9F%E8%8B%8F");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });
        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"正在跳转至音乐页面",Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(MainActivity.this,Music_MediaActivity.class);
                        startActivity(intent);
                    }
                },2500); // 延时2.5秒
            }
        });
        text7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"正在跳转至定位页面",Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(MainActivity.this,Fixed_PositionActivity.class);
                        startActivity(intent);
                    }
                },2500); // 延时2.5秒

            }
        });
    }
}