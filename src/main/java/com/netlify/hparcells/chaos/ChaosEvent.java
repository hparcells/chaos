package com.netlify.hparcells.chaos;

public abstract class ChaosEvent {
    public abstract void onEnable(String username);
    public void onDisable(String username) {}
    public abstract String getName();
}
