package com.themythichunter.chaos.events.explosivebeds;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.event.HandlerList;

public class ExplosiveBedsEvent extends ChaosEvent {
    private ExplosiveBedsListener explosiveBedsListener = new ExplosiveBedsListener();

    public void onEnable(String username, Chaos plugin) {
        plugin.getServer().getPluginManager().registerEvents(explosiveBedsListener, plugin);
    }

    public void onDisable(String username, Chaos plugin) {
        HandlerList.unregisterAll(explosiveBedsListener);
    }

    public String getName() {
        return "Explosive Beds";
    }
}
