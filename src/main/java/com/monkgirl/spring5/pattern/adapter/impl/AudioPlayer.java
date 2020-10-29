package com.monkgirl.spring5.pattern.adapter.impl;

import com.monkgirl.spring5.pattern.adapter.Player;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 09:56
 * @description
 */
public class AudioPlayer implements Player {

    @Override
    public void play(String type) {
        if("mp3".equalsIgnoreCase(type)){
            System.out.println("Playing mp3...");
        }else if(type.toLowerCase().matches("mp4|rmvb")){
            PlayerAdapter playerAdapter = new PlayerAdapter(type);
            playerAdapter.play(type);
        }
    }
}
