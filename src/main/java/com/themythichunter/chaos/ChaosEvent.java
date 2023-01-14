package com.themythichunter.chaos;

public abstract class ChaosEvent {
    public abstract void onEnable(String username, Chaos plugin);

    public void onDisable(String username, Chaos plugin) {
    }

    public abstract String getName();
}
