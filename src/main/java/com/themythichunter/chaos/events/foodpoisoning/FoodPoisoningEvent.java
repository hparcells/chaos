package com.themythichunter.chaos.events.foodpoisoning;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.event.HandlerList;

public class FoodPoisoningEvent extends ChaosEvent {
    private final FoodPoisoningListener foodPoisoningListener = new FoodPoisoningListener();

    public void onEnable(String username, Chaos plugin) {
        plugin.getServer().getPluginManager().registerEvents(foodPoisoningListener, plugin);
    }

    public void onDisable(String username, Chaos plugin) {
        HandlerList.unregisterAll(foodPoisoningListener);
    }

    public String getName() {
        return "Food Poisoning";
    }
}
