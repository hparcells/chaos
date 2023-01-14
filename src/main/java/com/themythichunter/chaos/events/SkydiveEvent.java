package com.themythichunter.chaos.events;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SkydiveEvent extends ChaosEvent {
    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            Location location = new Location(target.getWorld(), target.getLocation().getX(),
                                             target.getLocation().getY() + 100, target.getLocation().getZ()
            );
            target.teleport(location);
        }
    }

    public String getName() {
        return "Skydive";
    }
}
