package com.monkgirl.spring5.pattern.adapter.impl;

import com.monkgirl.spring5.pattern.adapter.AdvancedPlayer;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-27 09:34
 * @description
 */
public class MP4Player implements AdvancedPlayer {
    @Override
    public void playMP4() {
        System.out.println("Playing MP4.");
    }
}
