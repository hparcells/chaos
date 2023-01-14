package com.themythichunter.chaos.events;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.TreeType;
import org.bukkit.entity.Player;

public class TreeEvent extends ChaosEvent {
    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.getWorld().generateTree(target.getLocation(), TreeType.BIG_TREE);
        }
    }

    public String getName() {
        return "Tree";
    }
}
