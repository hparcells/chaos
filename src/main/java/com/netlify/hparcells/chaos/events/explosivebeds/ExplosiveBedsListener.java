package com.netlify.hparcells.chaos.events.explosivebeds;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class ExplosiveBedsListener implements Listener {
    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        Block bed = event.getBed();
        Location bedLocation = bed.getLocation();

        if(bed.getWorld().getEnvironment() == World.Environment.NORMAL) {
            bed.getWorld().createExplosion(bedLocation, 12f, true, true);
        }
    }
}
