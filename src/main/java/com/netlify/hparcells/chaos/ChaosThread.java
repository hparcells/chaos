package com.netlify.hparcells.chaos;

import com.netlify.hparcells.chaos.events.*;
import com.netlify.hparcells.chaos.events.explosivebeds.ExplosiveBedsEvent;
import com.netlify.hparcells.chaos.events.firetrail.FireTrailEvent;
import com.netlify.hparcells.chaos.events.foodpoisoning.FoodPoisoningEvent;
import com.netlify.hparcells.chaos.events.slipperybuckets.SlipperyBucketsEvent;
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
        new BedrockFeetEvent(),
        new HBannerEvent(),
        new BeefEvent(),
        new SkydiveEvent(),
        new ButterfingersEvent(),
        new TripEvent(),
        new SpeedEvent(),
        new JumpBoostEvent(),
        new FakeCreeperEvent(),
        new DiamondPickaxeEvent(),
        new BlindnessEvent(),
        new MiningFatigueEvent(),
        new HasteEvent(),
        new IgniteEvent(),
        new GardenerEvent(),
        new CreeperEvent(),
        new HalfHeartEvent(),
        new LightningEvent(),
        new AnvilEvent(),
        new ClearLagEvent(),
        new SkyLavaEvent(),
        new ZeroXpEvent(),
        new NiceXpEvent(),
        new HardEvent(),
        new TreeEvent(),
        new DiamondEvent(),
        new FireTrailEvent(),
        new ExplosiveBedsEvent(),
        new SlipperyBucketsEvent(),
        // new ChatKickEvent(),
        new FullHealEvent(),
        new FullHungerEvent(),
        new ZeroHungerEvent(),
        new FoodPoisoningEvent()
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
            Thread.sleep(
                ThreadLocalRandom.current().nextInt(plugin.minEventDuration, plugin.maxEventDuration + 1)
                * 1000
            );
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
                            currentChaosEvent.onEnable(player, plugin);
                        }
                    }.runTask(plugin);
                });
                if(spoilers) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "Chaos: " + currentChaosEvent.getName());
                }

                // Wait
                Thread.sleep(
                    ThreadLocalRandom.current().nextInt(
                        plugin.minEventDuration,
                        plugin.maxEventDuration + 1
                    )
                    * 1000
                );

                // Disable
                chaosPlayers.forEach((player) -> {
                    new BukkitRunnable() {
                        public void run() {
                            currentChaosEvent.onDisable(player, plugin);
                        }
                    }.runTask(plugin);
                });

                Thread.sleep(1000);
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
            new BukkitRunnable() {
                public void run() {
                    currentChaosEvent.onDisable(player, plugin);
                }
            }.runTask(plugin);
        });
    }

    public ArrayList<String> getPlayers() {
        return chaosPlayers;
    }
}
