package com.harnet.audioplayer.controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.harnet.audioplayer.R;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private TextView songNameTextView;
    private SeekBar volumeControl;
    private ImageButton play;
    private ImageButton pause;
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songNameTextView = findViewById(R.id.songInfo);
        volumeControl = findViewById(R.id.volumeControl);


//        volumeControl.setMax(maxVolume);
//        volumeControl.setProgress(currentVolume);
        play = findViewById(R.id.playBtn);
        pause = findViewById(R.id.pauseBtn);
        mediaPlayer = MediaPlayer.create(this, R.raw.marbles);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        assert audioManager != null;
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        playMusic();
        pauseMusic();
        seekBar(maxVolume);

    }

    public void playMusic(){
        play.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                songNameTextView.setText(Arrays.toString(mediaPlayer.getTrackInfo()));
            }
        });
    }

    public void pauseMusic(){
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
    }

    public void seekBar(final int maxVolume){
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
                Log.i("Seek bar change", String.valueOf(progress));
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
