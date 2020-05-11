package com.harnet.audioplayer.model.Buttons;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PlayBtn extends ControlBtn {
    private MediaPlayer mediaPlayer;


    public PlayBtn(String name, MediaPlayer mediaPlayer) {
        super(name);
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void clickAction(ImageButton btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
    }
}
