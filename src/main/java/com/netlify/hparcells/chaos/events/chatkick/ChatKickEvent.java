package com.netlify.hparcells.chaos.events.chatkick;

import com.netlify.hparcells.chaos.Chaos;
import com.netlify.hparcells.chaos.ChaosEvent;
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
