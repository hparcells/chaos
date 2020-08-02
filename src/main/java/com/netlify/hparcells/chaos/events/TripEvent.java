package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TripEvent extends ChaosEvent {
    public void onEnable(String username) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            for(ItemStack itemStack : target.getInventory().getContents()) {
                if(itemStack != null) {
                    Item droppedItem = target.getWorld().dropItemNaturally(target.getLocation(), itemStack);
                    target.getInventory().removeItem(itemStack);
                    droppedItem.setPickupDelay(100);
                }
            }
            target.getInventory().setHelmet(null);
            target.getInventory().setChestplate(null);
            target.getInventory().setLeggings(null);
            target.getInventory().setBoots(null);
            target.getInventory().setItemInOffHand(null);
        }
    }

    public String getName() {
        return "Trip";
    }
}
