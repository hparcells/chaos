package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.Chaos;
import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlindnessEvent extends ChaosEvent {
    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, Integer.MAX_VALUE, 1));
        }
    }

    public void onDisable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.removePotionEffect(PotionEffectType.BLINDNESS);
        }
    }

    public String getName() {
        return "Blind";
    }
}
