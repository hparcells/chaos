package com.themythichunter.chaos;

import java.util.ArrayList;

public class ChaosSettings {
    public int eventDuration;
    public Boolean spoilers;
    public int delay;

    public final ArrayList<String> chaosPlayers = new ArrayList<>();
    public ChaosEvent currentChaosEvent;

    public ChaosSettings(int eventDuration, Boolean spoilers, int delay) {
        this.eventDuration = eventDuration;
        this.spoilers = spoilers;
        this.delay = delay;
    }
}
