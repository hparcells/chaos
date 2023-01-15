package com.themythichunter.chaos.task;

import com.themythichunter.chaos.Chaos;

public class RunCycleTask implements Runnable {
    private final Chaos plugin;

    public RunCycleTask(Chaos plugin) {
        this.plugin = plugin;
    }

    public void run() {
        // Take away current event if it exists, then give them a new one.
        plugin.scheduler.runTask(plugin, new DisableEventTask(plugin));
        plugin.scheduler.runTask(plugin, new NewEventTask(plugin));

        // Take it back now y'all.
        plugin.scheduler.runTaskLater(plugin, new RunCycleTask(plugin), plugin.eventDuration * 20L);
    }
}
