package com.themythichunter.chaos.events.slipperybuckets;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class SlipperyBucketsListener implements Listener {
    @EventHandler
    public void onPlayerBucketEmptyEvent(PlayerBucketEmptyEvent event) {
        event.setCancelled(true);

        Player player = event.getPlayer();

        if(event.getBucket() == Material.WATER_BUCKET) {
            player.getLocation().getBlock().setType(Material.WATER);
        }else if(event.getBucket() == Material.LAVA_BUCKET) {
            player.getLocation().getBlock().setType(Material.LAVA);
        }
    }
}
