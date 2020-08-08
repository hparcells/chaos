package com.netlify.hparcells.chaos.events.foodpoisoning;

import com.netlify.hparcells.chaos.Chaos;
import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.event.HandlerList;

public class FoodPoisoningEvent extends ChaosEvent {
    private FoodPoisoningListener foodPoisoningListener = new FoodPoisoningListener();

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
