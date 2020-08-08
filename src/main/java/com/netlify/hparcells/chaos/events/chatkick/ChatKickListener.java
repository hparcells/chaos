package com.netlify.hparcells.chaos.events.chatkick;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatKickListener implements Listener {
    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        event.getPlayer().kickPlayer("Kicked for spamming.");
    }
}
