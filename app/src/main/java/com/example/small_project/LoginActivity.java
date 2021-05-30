package com.example.small_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import UserDao.DBOpenHelper;
import UserDao.UserData;

public class LoginActivity extends Activity {
    private Button button, button1,button2;
    private EditText user;
    private EditText password;
    private DBOpenHelper dbOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button) findViewById(R.id.button_login);
        button1 = (Button) findViewById(R.id.button_register);
        button2=(Button)findViewById(R.id.button_transplant);
        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        dbOpenHelper= new DBOpenHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = user.getText().toString().trim();
                String userPassword = password.getText().toString().trim();
                    if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userPassword)) {
                        ArrayList<UserData> data = dbOpenHelper.getAllData();
                        for (int i = 0; i < data.size(); i++) {
                            UserData user = data.get(i);
                            if (userName.equals(user.getUserName()) && userPassword.equals(user.getUserPassword())) {
                                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                }, 2500); // 延时2.5秒
                                break;
                            }else {
                                Toast.makeText(LoginActivity.this, "密码或账号错误", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }else {
                            Toast.makeText(LoginActivity.this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

