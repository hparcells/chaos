package com.themythichunter.chaos;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Chaos extends JavaPlugin {
    public ChaosConfigHandler chaosConfigHandler = new ChaosConfigHandler(this);
    public ChaosThread chaosThread = new ChaosThread("Chaos Thread", this);

    public int minEventDuration = 30;
    public int maxEventDuration = 40;

    @Override
    public void onEnable() {
        chaosConfigHandler.loadConfig();
        Objects.requireNonNull(this.getCommand("chaos")).setExecutor(new ChaosCommandExecutor(this));

        minEventDuration = Integer.parseInt(Objects.requireNonNull(chaosConfigHandler.chaosConfig.getString("config.event-duration.min")));
        maxEventDuration = Integer.parseInt(Objects.requireNonNull(chaosConfigHandler.chaosConfig.getString("config.event-duration.max")));

        getLogger().info("Chaos loaded.");
    }

    @Override
    public void onDisable() {
        chaosThread.stop();
        getLogger().info("Chaos disabled.");
    }
}
