package com.themythichunter.chaos.events.foodpoisoning;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FoodPoisoningListener implements Listener {
    @EventHandler
    public void onPlayerItemConsumeEvent(PlayerItemConsumeEvent event) {
        Material consumed = event.getItem().getType();

        if(consumed.isEdible()) {
            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 20 * 30, 0));
        }
    }
}
