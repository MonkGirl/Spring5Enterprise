package com.monkgirl.spring5.pattern.command;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 00:39
 * @description
 */
public class AttentionCommand implements Command{
    private Soldier soldier;

    public AttentionCommand(Soldier soldier){
        this.soldier = soldier;
    }

    @Override
    public void doCommand() {
        soldier.attention();
    }
}
