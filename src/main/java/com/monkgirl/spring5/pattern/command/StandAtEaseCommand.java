package com.monkgirl.spring5.pattern.command;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 00:42
 * @description
 */
public class StandAtEaseCommand implements Command{
    private Soldier soldier;

    public StandAtEaseCommand(Soldier soldier){
        this.soldier = soldier;
    }

    @Override
    public void doCommand() {
        soldier.standAtEase();
    }
}
