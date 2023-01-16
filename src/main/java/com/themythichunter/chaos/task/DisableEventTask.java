package com.themythichunter.chaos.task;

import com.themythichunter.chaos.Chaos;

public class DisableEventTask implements Runnable {
    private final Chaos plugin;

    public DisableEventTask(Chaos plugin) {
        this.plugin = plugin;
    }

    public void run() {
        plugin.stopCurrentEvent();
    }
}
