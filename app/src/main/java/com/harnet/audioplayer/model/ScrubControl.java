package com.harnet.audioplayer.model;

import android.media.AudioManager;
import android.widget.TextView;

public class ScrubControl {
    private AudioManager audioManager;
    private TextView remainingTime;

    public ScrubControl(AudioManager audioManager, TextView remainingTime) {
        this.audioManager = audioManager;
        this.remainingTime = remainingTime;
    }
}
