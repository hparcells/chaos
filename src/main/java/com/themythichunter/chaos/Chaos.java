package com.themythichunter.chaos;

import com.themythichunter.chaos.task.StopTask;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.Objects;

public final class Chaos extends JavaPlugin {
    public BukkitScheduler scheduler = getServer().getScheduler();

    public ChaosConfigHandler chaosConfigHandler = new ChaosConfigHandler(this);

    // Game Stuff
    // TODO: Maybe move?
    public int eventDuration = 30;
    public Boolean spoilers = false;
    public final ArrayList<String> chaosPlayers = new ArrayList<>();
    public ChaosEvent currentChaosEvent;

    @Override
    public void onEnable() {
        chaosConfigHandler.loadConfig();
        Objects.requireNonNull(this.getCommand("chaos")).setExecutor(new ChaosCommandExecutor(this));

        eventDuration = Integer.parseInt(Objects.requireNonNull(chaosConfigHandler.chaosConfig.getString("config.event-duration")));

        getLogger().info("Chaos loaded.");
    }

    @Override
    public void onDisable() {
        this.scheduler.runTask(this, new StopTask(this));
        getLogger().info("Chaos disabled.");
    }
}
