package com.example.small_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextClock;

public class Text_ClockActivity extends Activity {

    private TextClock mTextClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_clock);

//        mTextClock = (TextClock)findViewById(R.id.textclock_real_time);
//        // 设置12时制显示格式
//        mTextClock.setFormat12Hour("EEEE, MMMM dd, yyyy h:mmaa");
//        // 设置24时制显示格式
//        mTextClock.setFormat24Hour("yyyy-MM-dd hh:mm, EEEE");
    }
}