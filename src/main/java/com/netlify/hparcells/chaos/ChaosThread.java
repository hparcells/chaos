package com.netlify.hparcells.chaos;

import com.netlify.hparcells.chaos.events.ExampleChaosEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ChaosThread implements Runnable {
    private final String threadName;
    private final Chaos plugin;

    private Thread thread;

    private ArrayList<String> chaosPlayers = new ArrayList<String>();
    private Boolean spoilers = false;

    private ChaosEvent currentChaosEvent = new ExampleChaosEvent();

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
                // TODO: Select random chaos event.

                // Enable
                chaosPlayers.forEach((player) -> {
                    currentChaosEvent.onEnable((player));
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
