package com.example.small_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Music_MediaActivity extends Activity {
    private Button button_music_player,buttom_music_stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_media);
        button_music_player=findViewById(R.id.music_button_player);
        buttom_music_stop=findViewById(R.id.music_button_stop);
        final Intent intent=new Intent(Music_MediaActivity.this,Musicervice.class);
        button_music_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Musicervice.isPlay){
                    startService(intent);
                }
            }
        });
        buttom_music_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Musicervice.isPlay){
                    stopService(intent);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        startService(new Intent(Music_MediaActivity.this,Musicervice.class));
        super.onStart();
    }
}