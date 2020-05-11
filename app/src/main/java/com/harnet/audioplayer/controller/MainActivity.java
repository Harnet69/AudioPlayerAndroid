package com.harnet.audioplayer.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
import com.harnet.audioplayer.model.SongInfo;
import com.harnet.audioplayer.model.VolumeControl;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.marbles);
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        TextView songNameTextDisplay = findViewById(R.id.songInfoDisplay);
        TextView volumeLevelDisplay = findViewById(R.id.volumeLevelDisplay);
        Button muteBtnView = findViewById(R.id.muteBtn);
        SeekBar volumeControlView = findViewById(R.id.volumeControl);
        ImageButton playView = findViewById(R.id.playBtn);
        ImageButton pauseView = findViewById(R.id.pauseBtn);



        SongInfo songInfo = new SongInfo();
        assert audioManager != null;
        VolumeControl volumeControls = new VolumeControl(audioManager, volumeControlView, volumeLevelDisplay, muteBtnView);
        volumeLevelDisplay.setText(String.valueOf(Math.round(volumeControls.getCurrentVolume()*6.66)));
        MuteBtn muteBtn = new MuteBtn("Mute btn", audioManager, volumeControls);

        volumeControls.manageVolumeControl();
        ControlBtn playBtn = new PlayBtn("Play", mediaPlayer);
        ControlBtn pauseBtn = new PauseBtn("Pause", mediaPlayer);

        muteBtn.clickAction(muteBtnView);
        playBtn.clickAction(playView);
        pauseBtn.clickAction(pauseView);
    }
}
