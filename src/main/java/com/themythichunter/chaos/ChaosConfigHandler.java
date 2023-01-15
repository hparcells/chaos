package com.themythichunter.chaos;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ChaosConfigHandler {
    private final Chaos plugin;

    public FileConfiguration chaosConfig;
    public File chaosConfigFile;

    public ChaosConfigHandler(Chaos plugin) {
        this.plugin = plugin;
    }

    public void loadConfig() {
        if(!plugin.getDataFolder().exists()) {
            if(plugin.getDataFolder().mkdir()) {
                plugin.getLogger().info("Created plugin folder.");
            }
        }

        chaosConfigFile = new File(plugin.getDataFolder(), "config.yml");

        if(!chaosConfigFile.exists()) {
            try {
                if(chaosConfigFile.createNewFile()) {
                    plugin.getConfig().options().copyDefaults(true);
                    plugin.saveConfig();

                    plugin.getLogger().info("Created a config file.");
                }
            }catch(IOException e) {
                plugin.getLogger().info("Error when creating the config file.");
            }
        }

        reloadConfig();
    }

    public void reloadConfig() {
        chaosConfig = YamlConfiguration.loadConfiguration(chaosConfigFile);
    }
}
