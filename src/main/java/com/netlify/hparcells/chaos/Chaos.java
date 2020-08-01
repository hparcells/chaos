package com.netlify.hparcells.chaos;

import org.bukkit.plugin.java.JavaPlugin;

public final class Chaos extends JavaPlugin {
    public ChaosConfigHandler chaosConfigHandler = new ChaosConfigHandler(this);
    public ChaosThread chaosThread = new ChaosThread("chaosThread", this);

    public int minEventDuration = 30;
    public int maxEventDuration = 40;

    @Override
    public void onEnable() {
        chaosConfigHandler.loadConfig();
        this.getCommand("chaos").setExecutor(new ChaosCommandExecutor(this));

        minEventDuration = Integer.parseInt(chaosConfigHandler.chaosConfig.getString("config.event-duration.min"));
        maxEventDuration = Integer.parseInt(chaosConfigHandler.chaosConfig.getString("config.event-duration.max"));

        getLogger().info("Chaos loaded.");
    }

    @Override
    public void onDisable() {
        chaosThread.stop();
        getLogger().info("Chaos disabled.");
    }
}
