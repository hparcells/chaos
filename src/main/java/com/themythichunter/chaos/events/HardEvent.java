package com.themythichunter.chaos.events;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.entity.Player;

public class HardEvent extends ChaosEvent {
    private Difficulty beforeDifficulty;

    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            beforeDifficulty = target.getWorld().getDifficulty();
            target.getWorld().setDifficulty(Difficulty.HARD);
        }
    }

    public void onDisable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.getWorld().setDifficulty(beforeDifficulty);
        }
    }

    public String getName() {
        return "Hard";
    }
}
