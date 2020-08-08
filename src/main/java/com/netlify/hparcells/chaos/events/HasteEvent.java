package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.Chaos;
import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HasteEvent extends ChaosEvent {
    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 255));
        }
    }

    public void onDisable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.removePotionEffect(PotionEffectType.FAST_DIGGING);
        }
    }

    public String getName() {
        return "Haste";
    }
}
