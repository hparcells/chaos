package com.netlify.hparcells.chaos;

import com.netlify.hparcells.chaos.events.BedrockFeetEvent;
import com.netlify.hparcells.chaos.events.ExampleChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChaosThread implements Runnable {
    private final String threadName;
    private final Chaos plugin;

    private Thread thread;

    private ArrayList<String> chaosPlayers = new ArrayList<String>();
    private Boolean spoilers = false;

    private ChaosEvent[] chaosEvents = {
        new BedrockFeetEvent()
    };
    private ChaosEvent currentChaosEvent;

    ChaosThread(String name, Chaos plugin) {
        this.threadName = name;
        this.plugin = plugin;
    }

    public void addPlayer(String username) {
        if(!chaosPlayers.contains(username)) {
            chaosPlayers.add(username);
        }
    }
    public void removePlayer(String username) {
        if(chaosPlayers.contains(username)) {
            chaosPlayers.remove(chaosPlayers.indexOf(username));
        }
    }
    public Boolean toggleSpoilers() {
        spoilers = !spoilers;
        return spoilers;
    }

    public void run() {
        // Starting pause.
        try {
            Thread.sleep((ThreadLocalRandom.current().nextInt(plugin.minEventDuration, plugin.maxEventDuration + 1)) * 1000);
        }catch(InterruptedException e) {
            thread.interrupt();
        }

        // The loop.
        while(!thread.isInterrupted()) {
            try {
               currentChaosEvent = chaosEvents[new Random().nextInt(chaosEvents.length)];

                // Enable
                chaosPlayers.forEach((player) -> {
                    new BukkitRunnable() {
                        public void run() {
                            currentChaosEvent.onEnable((player));
                        }
                    }.runTask(plugin);
                });
                if(spoilers) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "Chaos: " + currentChaosEvent.getName());
                }

                // Wait
                Thread.sleep((ThreadLocalRandom.current().nextInt(plugin.minEventDuration, plugin.maxEventDuration + 1)) * 1000);

                // Disable
                chaosPlayers.forEach((player) -> {
                    currentChaosEvent.onDisable(player);
                });
            }catch(InterruptedException e) {
                thread.interrupt();
            }
        }
    }

    public Boolean start() {
        if(thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
            return true;
        }
        return false;
    }
    public void stop() {
        if(thread != null) {
            thread.interrupt();
            thread = null;
        }
        chaosPlayers.forEach((player) -> {
            currentChaosEvent.onDisable(player);
        });
    }

    public ArrayList<String> getPlayers() {
        return chaosPlayers;
    }
}
