package com.harnet.audioplayer.model.Buttons;

public abstract class ControlBtn implements Clickable  {
    private String name;

    public ControlBtn(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
