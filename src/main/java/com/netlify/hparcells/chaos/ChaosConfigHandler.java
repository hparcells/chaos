package com.netlify.hparcells.chaos;

import org.bukkit.ChatColor;
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
            plugin.getDataFolder().mkdir();
        }

        chaosConfigFile = new File(plugin.getDataFolder(), "config.yml");

        if(!chaosConfigFile.exists()) {
            try {
                chaosConfigFile.createNewFile();
                plugin.getConfig().options().copyDefaults(true);
                plugin.saveConfig();

                System.out.println("Created a config file.");
            }catch(IOException e) {
                System.out.println("Error when creating the config file.");
            }
        }

        reloadConfig();
    }

    public void reloadConfig() {
        chaosConfig = YamlConfiguration.loadConfiguration(chaosConfigFile);
    }
}
