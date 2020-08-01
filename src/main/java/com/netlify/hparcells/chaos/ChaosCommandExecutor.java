package com.netlify.hparcells.chaos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChaosCommandExecutor implements CommandExecutor {
    private final Chaos plugin;

    public ChaosCommandExecutor(Chaos plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args[0] == null) {
            return false;
        }
        if(args[0].equals("add")) {
            if(args[1] != null) {
                plugin.chaosThread.addPlayer(args[1]);
                sender.sendMessage(ChatColor.GREEN + args[1] + " has been added to the chaos players list.");
                return true;
            }
            return false;
        }
        if(args[0].equals("remove")) {
            if(args[1] != null) {
                plugin.chaosThread.removePlayer(args[1]);
                sender.sendMessage(ChatColor.GREEN + args[1] + " has been removed from  the chaos players list.");
                return true;
            }
            return false;
        }
        if(args[0].equals("start")) {
            sender.sendMessage(ChatColor.GREEN + "Starting the chaos...");

            plugin.chaosThread.start();
            return true;
        }
        if(args[0].equals("stop")) {
            sender.sendMessage(ChatColor.RED + "Stopping the chaos...");
            plugin.chaosThread.stop();
            return true;
        }
        if(args[0].equals("players")) {
            String players = plugin.chaosThread.getPlayers().toString();
            sender.sendMessage("Current Chaos Players: " + players);
            return true;
        }
        return false;
    }
}
