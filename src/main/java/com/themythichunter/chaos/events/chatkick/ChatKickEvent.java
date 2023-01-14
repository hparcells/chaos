package com.themythichunter.chaos.events.chatkick;

import com.themythichunter.chaos.Chaos;
import com.themythichunter.chaos.ChaosEvent;
import org.bukkit.event.HandlerList;

public class ChatKickEvent extends ChaosEvent {
    private ChatKickListener chatKickListener = new ChatKickListener();

    public void onEnable(String username, Chaos plugin) {
        plugin.getServer().getPluginManager().registerEvents(chatKickListener, plugin);
    }

    public void onDisable(String username, Chaos plugin) {
        HandlerList.unregisterAll(chatKickListener);
    }

    public String getName() {
        return "Chat Kick";
    }
}
