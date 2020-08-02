package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ButterfingersEvent extends ChaosEvent {
    public void onEnable(String username) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            ItemStack itemInHand = target.getInventory().getItemInMainHand();

            if(itemInHand != null && itemInHand.getType() != Material.AIR) {
                Item droppedMainHandItem = target.getWorld().dropItemNaturally(target.getLocation(), itemInHand);
                target.getInventory().remove(itemInHand);
                droppedMainHandItem.setPickupDelay(200);
            }
        }
    }
    public String getName() {
        return "Butterfingers";
    }
}
