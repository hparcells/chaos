package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ExampleChaosEvent extends ChaosEvent {
    public void onEnable(String username) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            System.out.println("Enabling for: " + username);
        }
    }
    public void onDisable(String username) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            System.out.println("Disabling for: " + username);
        }
    }
    public String getName() {
        return "Example Event";
    }
}
