package com.themythichunter.chaos.events.firetrail;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.event.HandlerList;

public class FireTrailEvent extends ChaosEvent {
    private FireTrailListener fireTrailListener = new FireTrailListener();

    public void onEnable(String username, Chaos plugin) {
        plugin.getServer().getPluginManager().registerEvents(fireTrailListener, plugin);
    }

    public void onDisable(String username, Chaos plugin) {
        HandlerList.unregisterAll(fireTrailListener);
    }

    public String getName() {
        return "Fire Trail";
    }
}
