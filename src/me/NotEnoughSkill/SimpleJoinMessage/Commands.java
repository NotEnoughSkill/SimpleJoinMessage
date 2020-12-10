package me.NotEnoughSkill.SimpleJoinMessage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("sjm.edit")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("on")) {
                        FileManager.messageOn();
                        p.sendMessage(String.valueOf(Main.prefix) + (Main.getInstance()).messageOn);
                    } else if (args[0].equalsIgnoreCase("off")) {
                        FileManager.messageOff();
                        p.sendMessage(String.valueOf(Main.prefix) + (Main.getInstance()).messageOff);
                    } else if (args[0].equalsIgnoreCase("help")) {
                        p.sendMessage("&cMessage: " +
                                Main.getInstance().toggle + "\n" + "&cJoinMessage: " + Main.getInstance().joinMessage +
                                "\n" + "&cLeaveMessage: " + Main.getInstance().leaveMessage + "\n" + "\n" +
                                "&cCommands:\n" + "&c/sjm <on/off> | Toggle the join message!\n" +
                                "&c/sjm setjoin <joinMessage> | Set the join message!\n" +
                                "&c/sjm setleave <leaveMessage> | Set the leave message!\n" +
                                "&c/sjm help | Display this help message!\n");
                    } else {
                        p.sendMessage(Main.getInstance().help);
                    }
                } else if (args.length >= 2) {
                    if (args[0].equalsIgnoreCase("setJoin")) {
                        String m = " ";
                        for (int i = 1; i < args.length; i++) {
                            m = String.valueOf(m) + args[i] + " ";
                        }
                        FileManager.setJoinMessage(m);
                        p.sendMessage("&cJoinMessage is now: " + m.replace('&', '§'));
                    } else if (args[0].equalsIgnoreCase("setLeave")) {
                        String m = " ";
                        for (int i = 1; i < args.length; i++) {
                            m = String.valueOf(m) + args[i] + " ";
                        }
                        FileManager.setLeaveMessage(m);
                        p.sendMessage("&cLeaveMessage is now: " + m.replace('&', '§'));
                    } else {
                        p.sendMessage(Main.getInstance().help);
                    }
                }
                return false;
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNot enough permissions!"));
            }
        }
        return false;
    }
}
