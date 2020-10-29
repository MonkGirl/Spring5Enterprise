package com.monkgirl.spring5.pattern.adapter.impl;

import com.monkgirl.spring5.pattern.adapter.AdvancedPlayer;
import com.monkgirl.spring5.pattern.adapter.Player;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 09:40
 * @description
 */
public class PlayerAdapter implements Player {

    private AdvancedPlayer advancedPlayer;

    public PlayerAdapter(String type){
        if("mp4".equalsIgnoreCase(type)){
            advancedPlayer = new com.monkgirl.spring5.pattern.adapter.impl.MP4Player();
        }else if("rmvb".equalsIgnoreCase(type)){
            advancedPlayer = new com.monkgirl.spring5.pattern.adapter.impl.RMVBPlayer();
        }
    }

    @Override
    public void play(String type) {
        if("mp4".equalsIgnoreCase(type)){
            advancedPlayer.playMP4();
        }else if("rmvb".equalsIgnoreCase(type)){
            advancedPlayer.playRMVB();
        }
    }
}
