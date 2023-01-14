package com.themythichunter.chaos.events.slipperybuckets;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.event.HandlerList;

public class SlipperyBucketsEvent extends ChaosEvent {
    private SlipperyBucketsListener slipperyBucketsListener = new SlipperyBucketsListener();

    public void onEnable(String username, Chaos plugin) {
        plugin.getServer().getPluginManager().registerEvents(slipperyBucketsListener, plugin);
    }

    public void onDisable(String username, Chaos plugin) {
        HandlerList.unregisterAll(slipperyBucketsListener);
    }

    public String getName() {
        return "Slippery Buckets";
    }
}
