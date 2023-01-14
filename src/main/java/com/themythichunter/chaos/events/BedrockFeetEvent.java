package com.themythichunter.chaos.events;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BedrockFeetEvent extends ChaosEvent {
    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.getLocation().subtract(0, 1, 0).getBlock().setType(Material.BEDROCK);
        }
    }

    public String getName() {
        return "Bedrock Feet";
    }
}
