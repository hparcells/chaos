package com.themythichunter.chaos.task;

import com.themythichunter.chaos.Chaos;
import org.bukkit.scheduler.BukkitTask;

public class RunCycleTask implements Runnable {
    private final Chaos plugin;

    public RunCycleTask(Chaos plugin) {
        this.plugin = plugin;
    }

    public void run() {
        // Take away current event if it exists.
        plugin.scheduler.runTask(plugin, new DisableEventTask(plugin));

        // Give them a new event in three seconds.
        BukkitTask task = plugin.scheduler.runTaskTimer(
                plugin,
                new RunCountdown(plugin, plugin.settings.delay),
                0L,
                20L
        );
        plugin.scheduler.runTaskLater(
                plugin,
                task::cancel,
                plugin.settings.delay * 20L
        );

        plugin.scheduler.runTaskLater(
                plugin,
                new NewEventTask(plugin),
                plugin.settings.delay * 20L
        );

        // Take it back now y'all.
        plugin.scheduler.runTaskLater(
                plugin,
                new RunCycleTask(plugin),
                (plugin.settings.eventDuration + plugin.settings.delay) * 20L
        );
    }
}
