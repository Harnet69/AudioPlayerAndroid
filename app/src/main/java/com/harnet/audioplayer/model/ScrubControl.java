package com.harnet.audioplayer.model;

import android.media.AudioManager;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class ScrubControl {
    private AudioManager audioManager;
    private SeekBar scrubControlView;
    private TextView remainingTime;

    public ScrubControl(AudioManager audioManager, SeekBar scrubControlView, TextView remainingTime) {
        this.audioManager = audioManager;
        this.remainingTime = remainingTime;
        this.scrubControlView = scrubControlView;
    }

    public void manageScrubControl(){
        scrubControlView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Scrub", String.valueOf(progress));
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
