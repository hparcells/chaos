package com.themythichunter.chaos.events;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ZeroHungerEvent extends ChaosEvent {
    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.setFoodLevel(0);
            target.setSaturation(0f);
        }
    }

    public String getName() {
        return "Zero Hunger";
    }
}
