package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MiningFatigueEvent extends ChaosEvent {
    public void onEnable(String username) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 255));
        }
    }
    public void onDisable(String username) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.removePotionEffect(PotionEffectType.SLOW_DIGGING);
        }
    }
    public String getName() {
        return "Mining Fatigue";
    }
}
