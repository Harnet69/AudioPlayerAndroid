package com.harnet.audioplayer.model;

import android.media.AudioManager;
import android.util.Log;
import android.widget.SeekBar;

public class VolumeControl {
    private AudioManager audioManager;
    private int maxVolume;
    private int currentVolume;

    public VolumeControl(AudioManager audioManager) {
        this.audioManager = audioManager;
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    public void manageVolumeControl(SeekBar volumeControl){

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
