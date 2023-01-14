package com.themythichunter.chaos.events.firetrail;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FireTrailListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Block block = event.getFrom().getBlock();

        if (block.getType() == Material.AIR) {
            block.setType(Material.FIRE);
        }
    }
}
