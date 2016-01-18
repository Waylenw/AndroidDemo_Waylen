package com.example.audioplear;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {
    private MediaPlayer player;
    private  SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(getApplicationContext(), R.raw.a);
         soundPool = new SoundPool(12, 0,5);
        AudioManager mgr = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
    }
    Runnable runnable=new Runnable(){


        @Override
        public void run() {

        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                soundPool.play(soundPool.load(this, R.raw.a, 1), 80,80, 0, 0, 1);
//                player.start();
                break;
            case R.id.btn_finsh:
//                player.pause();
                break;
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != player) {
            player.release();
        }
    }
}
