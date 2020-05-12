package com.harnet.audioplayer.model;

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
//                Log.i("Duration", String.valueOf(mediaPlayer.getDuration()));
//                Log.i("Scrub", String.valueOf(progress));
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
                remainingTimeView.setText(String.valueOf(songDuration - currentPosition));
            }
        }, 0, 1000);

    }
}
