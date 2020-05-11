package com.harnet.audioplayer.model.Buttons;

import android.media.AudioManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.core.content.ContextCompat;

import com.harnet.audioplayer.R;
import com.harnet.audioplayer.model.VolumeControl;

public class MuteBtn extends ControlBtn{
    private AudioManager audioManager;

    public MuteBtn(String name, AudioManager audioManager) {
        super(name);
        this.audioManager = audioManager;
    }


    public void clickAction(final Button btn, final VolumeControl volumeControls) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volumeControls.muteSound();
            }
        });

    }

    @Override
    public void clickAction(ImageButton btn) {

    }
}
