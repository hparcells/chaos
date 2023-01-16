package com.themythichunter.chaos.task;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.Events;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class NewEventTask implements Runnable {
    private final Chaos plugin;

    public NewEventTask(Chaos plugin) {
        this.plugin = plugin;
    }

    public void run() {
        plugin.settings.currentChaosEvent = Events.CHAOS_EVENTS[new Random().nextInt(Events.CHAOS_EVENTS.length)];

        // Enable
        plugin.settings.chaosPlayers.forEach((player) -> new BukkitRunnable() {
            public void run() {
                plugin.settings.currentChaosEvent.onEnable(player, plugin);
            }
        }.runTask(plugin));

        // Play Sound
        for(String username : plugin.settings.chaosPlayers) {
            Player player = Bukkit.getPlayer(username);

            if(player != null) {
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            }
        }

        // Spoilers
        if(plugin.settings.spoilers) {
            Bukkit.broadcastMessage(ChatColor.GREEN + "Chaos: " + plugin.settings.currentChaosEvent.getName());
        }
    }
}
