package com.harnet.audioplayer.model;

import android.media.AudioManager;
import android.media.MediaPlayer;

public class AudioPlayer {
    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;

    private PlayControl playControl;
    private VolumeControl volumeControl;
    private SongInfo songInfo;
}
