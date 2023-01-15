package com.themythichunter.chaos;

import com.themythichunter.chaos.task.RunCycleTask;
import com.themythichunter.chaos.task.StopTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChaosCommandExecutor implements CommandExecutor {
    private final Chaos plugin;

    private boolean isRunning = false;

    public ChaosCommandExecutor(Chaos plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("chaos.use")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            return false;
        }

        if(args[0] == null) {
            sender.sendMessage(ChatColor.RED + "Incorrect usage. Check the plugin page for more details.");
            return false;
        }
        if(args[0].equals("add")) {
            if(args[1] != null) {
                if(!plugin.chaosPlayers.contains(args[1])) {
                    plugin.chaosPlayers.add(args[1]);
                }
                sender.sendMessage(ChatColor.GREEN + args[1] + " has been added to the chaos players list.");
                return true;
            }else {
                sender.sendMessage(ChatColor.RED + "Incorrect usage. Must provide player name.");
            }
            return false;
        }
        if(args[0].equals("remove")) {
            if(args[1] != null) {
                plugin.chaosPlayers.remove(args[1]);
                sender.sendMessage(ChatColor.GREEN + args[1] + " has been removed from  the chaos players list.");
                return true;
            }else {
                sender.sendMessage(ChatColor.RED + "Incorrect usage. Must provide player name.");
            }
            return false;
        }
        if(args[0].equals("start")) {
            if(!isRunning) {
                Bukkit.broadcastMessage(ChatColor.GREEN + "Starting the chaos...");
                plugin.scheduler.runTaskLater(plugin, new RunCycleTask(plugin), plugin.eventDuration * 20L);
                isRunning = true;
            }else {
                sender.sendMessage(ChatColor.RED + "Can not start another chaos game when another one is in progress.");
            }
            return true;
        }
        if(args[0].equals("stop")) {
            Bukkit.broadcastMessage(ChatColor.RED + "Stopping the chaos...");
            plugin.scheduler.runTask(plugin, new StopTask(plugin));
            isRunning = false;

            return true;
        }
        if(args[0].equals("players")) {
            String players = plugin.chaosPlayers.toString();
            sender.sendMessage(ChatColor.GREEN + "Current Chaos Players: " + players);
            return true;
        }
        if(args[0].equals("spoilers")) {
            plugin.spoilers = !plugin.spoilers;

            if(plugin.spoilers) {
                Bukkit.broadcastMessage(ChatColor.GREEN + "Spoilers: ON");
            }else {
                Bukkit.broadcastMessage(ChatColor.RED + "Spoilers: OFF");
            }
            return true;
        }

        sender.sendMessage(ChatColor.RED + "Incorrect usage. Check the plugin page for more details.");
        return false;
    }
}
