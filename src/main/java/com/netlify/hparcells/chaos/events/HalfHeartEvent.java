package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class HalfHeartEvent extends ChaosEvent {
    public void onEnable(String username) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.setHealth(1);
        }
    }

    public String getName() {
        return "Half a Heart";
    }
}
