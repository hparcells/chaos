package com.themythichunter.chaos.events;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ButterfingersEvent extends ChaosEvent {
    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            ItemStack itemInHand = target.getInventory().getItemInMainHand();

            if(itemInHand != null && itemInHand.getType() != Material.AIR) {
                Item droppedMainHandItem = target.getWorld().dropItemNaturally(target.getLocation(), itemInHand);
                target.getInventory().remove(itemInHand);
                droppedMainHandItem.setPickupDelay(100);
            }
        }
    }

    public String getName() {
        return "Butterfingers";
    }
}
