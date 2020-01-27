package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.Timer;
import java.util.TimerTask;

public class music extends AppCompatActivity {
SeekBar seekvol,seekprog;
MediaPlayer player;
AudioManager audioManager;
    public void play(View view){
        Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
        player.start();
    }
    public void pause(View view){
        Toast.makeText(this,"Pause",Toast.LENGTH_SHORT).show();
        player.pause();
    }
    public void stop(View view){
        Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show();
        player.stop();
        finish();
//      player.stop();
//      seekprog.setMax(0);
    }


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        player = MediaPlayer.create(this,R.raw.filp);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        seekvol = findViewById(R.id.seekVol);
        seekprog =findViewById(R.id.seekprog);

        int maxVol =audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVol =audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekvol.setMax(maxVol);
        seekvol.setProgress(curVol);

        seekvol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekprog.setMax(player.getDuration());
new Timer().scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        seekprog.setProgress(player.getCurrentPosition());
    }
},0,1500);

        seekprog.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                player.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
