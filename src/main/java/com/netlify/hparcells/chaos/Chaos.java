package com.netlify.hparcells.chaos;

import org.bukkit.plugin.java.JavaPlugin;

public final class Chaos extends JavaPlugin {
    public ChaosThread chaosThread = new ChaosThread("chaosThread");

    @Override
    public void onEnable() {
        this.getCommand("chaos").setExecutor(new ChaosCommandExecutor(this));
        getLogger().info("Chaos loaded.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Chaos disabled.");
    }
}
