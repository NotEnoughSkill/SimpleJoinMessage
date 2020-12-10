package me.NotEnoughSkill.SimpleJoinMessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;

    public static String prefix;

    public String joinMessage;

    public String leaveMessage;

    public String noPerm;

    public String messageOn;

    public String messageOff;

    public Boolean toggle;

    public String help;

    public void onEnable() {
        instance = this;
        FileManager.setNormalConfig();
        FileManager.readNormalConfig();

        PluginManager pm = Bukkit.getPluginManager();
        Bukkit.getPluginManager().registerEvents(new JoinMessage(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents(new LeaveMessage(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents(new KickMessage(), (Plugin)this);

        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c------------------------"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4SimpleJoinMessage Made By"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4NotEnoughSkill"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c------------------------"));

        Bukkit.getPluginCommand("simplejoinmessage").setExecutor(new Commands());
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c------------------------"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4SimpleJoinMessage Made By"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4NotEnoughSkill"));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c------------------------"));
    }

    public static Main getInstance() {
        return instance;
    }
}
