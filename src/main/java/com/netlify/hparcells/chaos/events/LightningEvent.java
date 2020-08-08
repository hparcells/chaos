package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.Chaos;
import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class LightningEvent extends ChaosEvent {
    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.getWorld().strikeLightning(target.getLocation());
        }
    }

    public String getName() {
        return "Zeus";
    }
}
