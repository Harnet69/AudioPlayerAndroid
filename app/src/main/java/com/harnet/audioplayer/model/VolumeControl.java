package com.harnet.audioplayer.model;

import android.media.AudioManager;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class VolumeControl {
    private AudioManager audioManager;
    private int maxVolume;
    private int currentVolume;
    private TextView volumeLevelDisplay;

    public VolumeControl(AudioManager audioManager, TextView volumeLevelDisplay) {
        this.audioManager = audioManager;
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        this.volumeLevelDisplay = volumeLevelDisplay;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void manageVolumeControl(final SeekBar volumeControl, final TextView volumeLevelDisplay){
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currentVolume); // save a current volume level

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
//                Log.i("Seek bar change", String.valueOf(progress));
                volumeLevelDisplay.setText(String.valueOf(Math.round(progress*6.66)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void muteSound(){
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0,0);
        volumeLevelDisplay.setText(String.valueOf(0));
    }
}
