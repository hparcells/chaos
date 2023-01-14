package com.themythichunter.chaos.events;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FullHealEvent extends ChaosEvent {
    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.setHealth(20);
        }
    }

    public String getName() {
        return "Full Heal";
    }
}
