package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class ZeroXpEvent extends ChaosEvent {
    public void onEnable(String username) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.setLevel(0);
        }
    }

    public String getName() {
        return "Zero XP";
    }
}
