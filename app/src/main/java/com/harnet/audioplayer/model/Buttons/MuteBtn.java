package com.harnet.audioplayer.model.Buttons;

import android.media.AudioManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MuteBtn extends ControlBtn{
    private AudioManager audioManager;

    public MuteBtn(String name, AudioManager audioManager) {
        super(name);
        this.audioManager = audioManager;
    }


    public void clickAction(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0,0);
            }
        });
    }

    @Override
    public void clickAction(ImageButton btn) {

    }
}
