package com.themythichunter.chaos.events;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class ClearLagEvent extends ChaosEvent {
    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {

            for(Entity entity : target.getWorld().getEntities()) {
                if(entity instanceof Item) {
                    entity.remove();
                }
            }
        }
    }

    public String getName() {
        return "ClearLag";
    }
}
