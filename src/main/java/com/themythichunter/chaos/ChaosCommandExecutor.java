package com.themythichunter.chaos;

import com.themythichunter.chaos.task.RunCycleTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

        if(args.length == 0) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            }
            sender.sendMessage(ChatColor.GREEN + "Chaos v" + plugin.getDescription().getVersion() + ChatColor.RESET + " by " + ChatColor.GREEN + "MythicHunter758" + ChatColor.RESET + " - Get started by running \"/chaos add [player]\" then \"/chaos start\".");
            return false;
        }
        if(args[0].equalsIgnoreCase("add")) {
            if(args[1] != null) {
                if(!plugin.settings.chaosPlayers.contains(args[1])) {
                    plugin.settings.chaosPlayers.add(args[1]);
                }
                sender.sendMessage(ChatColor.GREEN + args[1] + " has been added to the chaos players list.");
                return true;
            }else {
                sender.sendMessage(ChatColor.RED + "Incorrect usage. Must provide player name.");
            }
            return false;
        }
        if(args[0].equalsIgnoreCase("remove")) {
            if(args[1] != null) {
                plugin.settings.chaosPlayers.remove(args[1]);
                sender.sendMessage(ChatColor.GREEN + args[1] + " has been removed from  the chaos players list.");
                return true;
            }else {
                sender.sendMessage(ChatColor.RED + "Incorrect usage. Must provide player name.");
            }
            return false;
        }
        if(args[0].equalsIgnoreCase("start")) {
            if(!isRunning) {
                Bukkit.broadcastMessage(ChatColor.GREEN + "Starting the chaos...");
                for(String username : plugin.settings.chaosPlayers) {
                    Player player = Bukkit.getPlayer(username);

                    if(player != null) {
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 2);
                    }
                }
                plugin.scheduler.runTaskLater(plugin, new RunCycleTask(plugin), plugin.settings.eventDuration * 20L);
                isRunning = true;
            }else {
                sender.sendMessage(ChatColor.RED + "Can not start another chaos game when another one is in progress.");
            }
            return true;
        }
        if(args[0].equalsIgnoreCase("stop")) {
            Bukkit.broadcastMessage(ChatColor.RED + "Stopping the chaos...");
            for(String username : plugin.settings.chaosPlayers) {
                Player player = Bukkit.getPlayer(username);

                if(player != null) {
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                }
            }

            plugin.stopChaos();

            isRunning = false;

            return true;
        }
        if(args[0].equalsIgnoreCase("players")) {
            String players = plugin.settings.chaosPlayers.toString();
            sender.sendMessage(ChatColor.GREEN + "Current Chaos Players: " + players);
            return true;
        }
        if(args[0].equalsIgnoreCase("spoilers")) {
            plugin.settings.spoilers = !plugin.settings.spoilers;

            if(plugin.settings.spoilers) {
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
