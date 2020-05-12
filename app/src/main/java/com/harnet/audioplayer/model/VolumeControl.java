package com.harnet.audioplayer.model;

import android.graphics.PorterDuff;
import android.media.AudioManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.harnet.audioplayer.R;

public class VolumeControl {
    private AudioManager audioManager;
    private SeekBar volumeControl;
    private TextView volumeLevelDisplay;
    private int maxVolume;
    private int currentVolume;
    private Button muteBtnView;
    private boolean isSoundMute;

    public VolumeControl(AudioManager audioManager, SeekBar volumeControl, TextView volumeLevelDisplay, Button muteBtnView) {
        this.audioManager = audioManager;
        this.volumeControl = volumeControl;
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        this.volumeLevelDisplay = volumeLevelDisplay;
        this.muteBtnView = muteBtnView;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public boolean isSoundMute() {
        return isSoundMute;
    }

    public void manageVolumeControl(){
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currentVolume); // save a current volume level

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
                volumeLevelDisplay.setText(String.valueOf(Math.round(progress*6.66)));
                muteBtnView.setBackgroundResource(R.drawable.unmute_btn);
                volumeControl.getProgressDrawable().setColorFilter(0xFF00FFFF, PorterDuff.Mode.MULTIPLY);
                currentVolume = progress;
                isSoundMute = false;
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
        muteBtnView.setBackgroundResource(R.drawable.mute_btn);
        volumeControl.getProgressDrawable().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);
        isSoundMute = true;
    }

    public void unmuteSound(){
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume,0);
        volumeLevelDisplay.setText(String.valueOf(Math.round(currentVolume*6.66))); // BUG
        muteBtnView.setBackgroundResource(R.drawable.unmute_btn);
        volumeControl.getProgressDrawable().setColorFilter(0xFF00FFFF, PorterDuff.Mode.MULTIPLY);
        isSoundMute = false;
    }
}
