package com.netlify.hparcells.chaos.events;

import com.netlify.hparcells.chaos.ChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GardenerEvent extends ChaosEvent {
    public void onEnable(String username) {
        Player target = (Bukkit.getServer().getPlayer(username));

        if(target != null) {
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.OAK_SAPLING, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.SPRUCE_SAPLING, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.BIRCH_SAPLING, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.JUNGLE_SAPLING, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.ACACIA_SAPLING, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.DARK_OAK_SAPLING, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.GRASS, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.FERN, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.DEAD_BUSH, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.SEAGRASS, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.SEA_PICKLE, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.DANDELION, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.POPPY, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.BLUE_ORCHID, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.ALLIUM, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.AZURE_BLUET, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.RED_TULIP, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.ORANGE_TULIP, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.WHITE_TULIP, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.PINK_TULIP, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.OXEYE_DAISY, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.CORNFLOWER, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.LILY_OF_THE_VALLEY, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.WITHER_ROSE, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.BROWN_MUSHROOM, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.RED_MUSHROOM, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.CRIMSON_FUNGUS, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.WARPED_FUNGUS, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.CRIMSON_ROOTS, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.WARPED_ROOTS, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.NETHER_SPROUTS, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.WEEPING_VINES, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.TWISTING_VINES, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.SUGAR_CANE, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.KELP, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.BAMBOO, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.VINE, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.LILY_PAD, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.LILAC, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.ROSE_BUSH, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.PEONY, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.TALL_GRASS, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.LARGE_FERN, 16));
            target.getWorld().dropItemNaturally(target.getLocation(), new ItemStack(Material.SWEET_BERRIES, 16));
        }
    }

    public String getName() {
        return "Gardener";
    }
}
