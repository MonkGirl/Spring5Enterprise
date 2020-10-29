package com.monkgirl.spring5.pattern.memento;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 10:50
 * @description
 */
public class Original {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveMementoState(){
        return new Memento(state);
    }

    public void getMementoState(Memento memento){
        state = memento.getState();
    }
}
