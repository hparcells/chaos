package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.Chaos;
import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.List;

public class HBannerEvent extends ChaosEvent {
    public void onEnable(String username, Chaos plugin) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            ItemStack banner = new ItemStack(Material.WHITE_BANNER);

            BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();
            List<Pattern> patterns = new ArrayList<Pattern>();
            patterns.add(new Pattern(DyeColor.RED, PatternType.STRIPE_LEFT));
            patterns.add(new Pattern(DyeColor.RED, PatternType.STRIPE_RIGHT));
            patterns.add(new Pattern(DyeColor.RED, PatternType.STRIPE_MIDDLE));
            patterns.add(new Pattern(DyeColor.WHITE, PatternType.BORDER));

            bannerMeta.setPatterns(patterns);
            bannerMeta.setDisplayName("The Holy H Banner");

            banner.setItemMeta(bannerMeta);

            target.getInventory().addItem(banner);
        }
    }

    public String getName() {
        return "H";
    }
}
