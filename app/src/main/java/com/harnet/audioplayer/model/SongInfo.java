package com.harnet.audioplayer.model;

import android.media.MediaPlayer;

import java.io.File;

public class SongInfo {
    private String displayedText;

    // TODO remove hadcode
    public SongInfo() {
        File file = new File("raw/old_car.mp3");
        this.displayedText = file.getName();
    }

    public String getDisplayedText() {
        return displayedText;
    }

    public void setDisplayedText(String displayedText) {
        this.displayedText = displayedText;
    }
}
