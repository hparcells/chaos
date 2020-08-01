package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ExampleChaosEvent extends ChaosEvent {
    public void onEnable(String username) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.getInventory().addItem(new ItemStack(Material.IRON_AXE));
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
