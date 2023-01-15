package com.themythichunter.chaos.task;

import com.themythichunter.chaos.Chaos;
import org.bukkit.scheduler.BukkitRunnable;

public class DisableEventTask implements Runnable {
    private final Chaos plugin;

    public DisableEventTask(Chaos plugin) {
        this.plugin = plugin;
    }

    public void run() {
        if(plugin.currentChaosEvent != null) {
            plugin.chaosPlayers.forEach((player) -> new BukkitRunnable() {
                public void run() {
                    plugin.currentChaosEvent.onDisable(player, plugin);
                }
            }.runTask(plugin));
        }
    }
}
