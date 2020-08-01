package com.netlify.hparcells.chaos;

public abstract class ChaosEvent {
    public String name;

    public abstract void onEnable(String username);
    public void onDisable(String username) {}
}
