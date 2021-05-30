package com.example.small_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import UserDao.DBOpenHelper;

public class RegisterActivity extends Activity {
    private EditText register_user;
    private EditText register_password;
    private EditText register_password_sure;
    private Button register_login;
    private Button register_cancel;
    private DBOpenHelper dbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_user = (EditText) findViewById(R.id.register_user);
        register_password = (EditText) findViewById(R.id.register_password);
        register_password_sure = (EditText) findViewById(R.id.register_password_sure);
        register_login = (Button) findViewById(R.id.register_login);
        register_cancel = (Button) findViewById(R.id.register_cancel);
        dbOpenHelper = new DBOpenHelper(getApplicationContext());
    //注册界面两个按钮的监听事件//不同按钮按下的监听事件选择
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_cancel: //返回登录页面
                Intent intent1 = new Intent(this, LoginActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.register_login:    //注册按钮
                //获取用户输入的用户名、密码、
                String username = register_user.getText().toString().trim();
                String password = register_password.getText().toString().trim();
                String password_sure = register_password_sure.getText().toString().trim();
                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    if (password.equals(password_sure)) {
                        //将用户名和密码加入到数据库中
                        dbOpenHelper.add(username, password);
                        Intent intent2 = new Intent(this, LoginActivity.class);
                        startActivity(intent2);
                        finish();
                        Toast.makeText(this, "验证通过，注册成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "验证码错误,注册失败", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "未完善信息，注册失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}






