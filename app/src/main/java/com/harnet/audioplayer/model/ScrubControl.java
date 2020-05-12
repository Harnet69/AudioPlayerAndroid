package com.harnet.audioplayer.model;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ScrubControl {
    private MediaPlayer mediaPlayer;
    private SeekBar scrubControlView;
    private TextView remainingTimeView;
    private int songDuration;

    public ScrubControl(MediaPlayer mediaPlayer, SeekBar scrubControlView, TextView remainingTime) {
        this.mediaPlayer = mediaPlayer;
        this.remainingTimeView = remainingTime;
        this.scrubControlView = scrubControlView;
        songDuration = mediaPlayer.getDuration();
    }


    public void manageScrubControl(){
        timer();
        scrubControlView.setMax(mediaPlayer.getDuration());

        scrubControlView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    // get current position of song every one second
    private void timer(){
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                int currentPosition = mediaPlayer.getCurrentPosition();
                scrubControlView.setProgress(currentPosition);
                if(songDuration > currentPosition){
                    remainingTimeView.setText(convertTime(songDuration - currentPosition));
                }else{
                    remainingTimeView.setText(convertTime(songDuration));
                }
            }
        }, 0, 500);
    }

    @SuppressLint("DefaultLocale")
    private String convertTime(int durationInMillis){
//        long millis = durationInMillis % 1000;
        long second = (durationInMillis / 1000) % 60;
        long minute = (durationInMillis / (1000 * 60)) % 60;
        long hour = (durationInMillis / (1000 * 60 * 60)) % 24;

        return String.format("%01d:%02d:%02d", hour, minute, second);
    }
}
