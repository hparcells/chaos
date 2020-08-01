package com.netlify.hparcells.chaos;

import com.netlify.hparcells.chaos.events.ExampleChaosEvent;

import java.util.ArrayList;

public class ChaosThread implements Runnable {
    private Thread thread;
    private String threadName;
    private ArrayList<String> chaosPlayers = new ArrayList<String>();
    private ChaosEvent currentChaosEvent = new ExampleChaosEvent();

    ChaosThread(String name) {
        threadName = name;
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

    public void run() {
        while(!thread.isInterrupted()) {
            try {
                // TODO: Select random chaos event.

                // Enable
                chaosPlayers.forEach((player) -> {
                    currentChaosEvent.onEnable((player));
                });

                // Wait
                Thread.sleep(10000);

                // Disable
                chaosPlayers.forEach((player) -> {
                    currentChaosEvent.onDisable(player);
                });
            }catch(InterruptedException e) {
                thread.interrupt();
            }
        }
    }

    public void start() {
        if(thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
    public void stop() {
        thread.interrupt();
        chaosPlayers.forEach((player) -> {
            currentChaosEvent.onDisable(player);
        });
    }

    public ArrayList<String> getPlayers() {
        return chaosPlayers;
    }
}
