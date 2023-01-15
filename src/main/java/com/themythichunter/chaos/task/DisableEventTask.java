package com.themythichunter.chaos.task;

import com.themythichunter.chaos.Chaos;

public class DisableEventTask implements Runnable {
    private final Chaos plugin;

    public DisableEventTask(Chaos plugin) {
        this.plugin = plugin;
    }

    public void run() {
        if(plugin.currentChaosEvent != null) {
            for(String username : plugin.chaosPlayers) {
                plugin.currentChaosEvent.onDisable(username, plugin);
            }
        }
    }
}
