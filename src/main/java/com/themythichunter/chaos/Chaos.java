package com.themythichunter.chaos;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Objects;

public final class Chaos extends JavaPlugin {
    public BukkitScheduler scheduler = getServer().getScheduler();

    public ChaosConfigHandler configHandler = new ChaosConfigHandler(this);
    public ChaosSettings settings;

    /**
     * Takes away the current event.
     */
    public void stopCurrentEvent() {
        if(this.settings.currentChaosEvent != null) {
            for(String username : this.settings.chaosPlayers) {
                this.settings.currentChaosEvent.onDisable(username, this);
            }
        }
    }

    /**
     * Completely stops the Chaos game.
     */
    public void stopChaos() {
        this.stopCurrentEvent();
        this.scheduler.cancelTasks(this);
    }

    @Override
    public void onEnable() {
        configHandler.loadConfig();
        Objects.requireNonNull(this.getCommand("chaos")).setExecutor(new ChaosCommandExecutor(this));

        settings = new ChaosSettings(
                configHandler.config.getInt("config.event-duration"),
                configHandler.config.getBoolean("config.spoilers"),
                configHandler.config.getInt("config.delay")
        );

        getLogger().info("Chaos loaded.");
    }

    @Override
    public void onDisable() {
        this.stopChaos();

        getLogger().info("Chaos disabled.");
    }
}
