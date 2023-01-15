package com.themythichunter.chaos.task;

import com.themythichunter.chaos.Chaos;

public class StopTask implements Runnable {
    private final Chaos plugin;

    public StopTask(Chaos plugin) {
        this.plugin = plugin;
    }

    public void run() {
        plugin.scheduler.runTask(plugin, new DisableEventTask(plugin));
        plugin.scheduler.cancelTasks(plugin);
    }
}
