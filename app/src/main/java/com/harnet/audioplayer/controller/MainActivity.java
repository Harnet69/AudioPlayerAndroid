package com.harnet.audioplayer.controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.harnet.audioplayer.R;
import com.harnet.audioplayer.model.Buttons.ControlBtn;
import com.harnet.audioplayer.model.Buttons.MuteBtn;
import com.harnet.audioplayer.model.Buttons.PauseBtn;
import com.harnet.audioplayer.model.Buttons.PlayBtn;
import com.harnet.audioplayer.model.ScrubControl;
import com.harnet.audioplayer.model.SongInfo;
import com.harnet.audioplayer.model.VolumeControl;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO implement audiotheque
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.old_car);
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        TextView songNameTextDisplay = findViewById(R.id.songInfoDisplay);
        TextView volumeLevelDisplay = findViewById(R.id.volumeLevelDisplay);
        TextView remainingTimeDisplay = findViewById(R.id.remainingTime);
        Button muteBtnView = findViewById(R.id.muteBtn);
        SeekBar volumeControlView = findViewById(R.id.volumeControl);
        SeekBar scrubControlView = findViewById(R.id.scrubControl);
        ImageButton playView = findViewById(R.id.playBtn);
        ImageButton pauseView = findViewById(R.id.pauseBtn);

        // Song info displaying (HARDCODED for testing)
        SongInfo songInfo = new SongInfo();
        songNameTextDisplay.setText(songInfo.getDisplayedText());

        // Volume controls
        assert audioManager != null;
        VolumeControl volumeControls = new VolumeControl(audioManager, volumeControlView, volumeLevelDisplay, muteBtnView);
        volumeLevelDisplay.setText(String.valueOf(Math.round(volumeControls.getCurrentVolume()*6.66)));
        MuteBtn muteBtn = new MuteBtn("Mute btn", audioManager, volumeControls);
        volumeControls.manageVolumeControl();
        muteBtn.clickAction(muteBtnView);

        // Playing controls
        ControlBtn playBtn = new PlayBtn("Play", mediaPlayer);
        ControlBtn pauseBtn = new PauseBtn("Pause", mediaPlayer);
        playBtn.clickAction(playView);
        pauseBtn.clickAction(pauseView);

        // Progress bar controls
        ScrubControl scrubControls = new ScrubControl(mediaPlayer, scrubControlView, remainingTimeDisplay);
        scrubControls.manageScrubControl();
    }
}
