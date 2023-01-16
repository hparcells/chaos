package com.themythichunter.chaos.task;

import com.themythichunter.chaos.Chaos;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class RunCountdown implements Runnable {
    private final Chaos plugin;

    private int seconds;

    public RunCountdown(Chaos plugin, int seconds) {
        this.plugin = plugin;
        this.seconds = seconds;
    }

    public void run() {
        if(this.seconds == 0) {
            return;
        }

        for(String username : plugin.settings.chaosPlayers) {
            Player player = Bukkit.getPlayer(username);

            if(player != null) {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
            }
        }
        this.seconds--;
    }
}
