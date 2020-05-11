package com.harnet.audioplayer.model.Buttons;

import android.media.AudioManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.harnet.audioplayer.model.VolumeControl;

public class MuteBtn extends ControlBtn{
    private AudioManager audioManager;
    private VolumeControl volumeControls;

    public MuteBtn(String name, AudioManager audioManager, VolumeControl volumeControls) {
        super(name);
        this.audioManager = audioManager;
        this.volumeControls = volumeControls;
    }


    public void clickAction(final Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(volumeControls.isSoundMute()){
                    volumeControls.unmuteSound();
                }else{
                    volumeControls.muteSound();
                }
            }
        });

    }

    @Override
    public void clickAction(ImageButton btn) {

    }
}
