package me.NotEnoughSkill.SimpleJoinMessage;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {
    static File config;

    public static File getConfigFile() {
        return config = new File("plugins/SimpleJoinMessage", "config.yml");
    }

    public static FileConfiguration getConfigFileConfig() {
        return (FileConfiguration) YamlConfiguration.loadConfiguration(getConfigFile());
    }

    public static void setNormalConfig() {
        FileConfiguration cfg = getConfigFileConfig();
        cfg.options().copyDefaults(true);
        cfg.addDefault("name", "Config");
        cfg.addDefault("toggle", "true");
        cfg.addDefault("prefix", "&f&l[&c&lSJM&f&l]");
        cfg.addDefault("noperm", "&4&lYou don't have enough permissions to do this!");
        cfg.addDefault("help", "&4&lIncorrect Usage: /sjm help");
        cfg.addDefault("togglemessage-on", "&c&lSimpleJoinMessage On!");
        cfg.addDefault("togglemessage-off", "&4&lSimpleJoinMessage Off!");
        cfg.addDefault("joinmessage", "&f&l[&c&l+&f&l] {player}");
        cfg.addDefault("leavemessage", "&f&l[&4&l-&f&l] {player}");

        try {
            cfg.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readNormalConfig() {
        FileConfiguration cfg = getConfigFileConfig();
        Main.getInstance();
        Main.getInstance().joinMessage = String.valueOf(ChatColor.translateAlternateColorCodes('&', cfg.getString("joinmessage"))) + " &r";
        Main.getInstance().leaveMessage = String.valueOf(ChatColor.translateAlternateColorCodes('&', cfg.getString("leavemessage"))) + " &r";
        Main.prefix = String.valueOf(ChatColor.translateAlternateColorCodes('&', cfg.getString("prefix"))) + " &r";
        Main.getInstance().noPerm = String.valueOf(ChatColor.translateAlternateColorCodes('&', cfg.getString("noperm"))) + " &r";
        Main.getInstance().messageOn = String.valueOf(ChatColor.translateAlternateColorCodes('&', cfg.getString("togglemessage-on"))) + " &r";
        Main.getInstance().messageOff = String.valueOf(ChatColor.translateAlternateColorCodes('&', cfg.getString("togglemessage-off"))) + " &r";
        Main.getInstance().help = String.valueOf(ChatColor.translateAlternateColorCodes('&', cfg.getString("help"))) + " &r";
        Main.getInstance().toggle = Boolean.valueOf(Boolean.parseBoolean(cfg.getString("toggle")));
    }

    public static void messageOn() {
        FileConfiguration cfg = getConfigFileConfig();
        cfg.options().copyDefaults(true);
        cfg.set("toggle", "true");
        try {
            cfg.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        readNormalConfig();
    }

    public static void messageOff() {
        FileConfiguration cfg = getConfigFileConfig();
        cfg.options().copyDefaults(true);
        cfg.set("toggle", "false");
        try {
            cfg.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        readNormalConfig();
    }

    public static void setJoinMessage(String message) {
        FileConfiguration cfg = getConfigFileConfig();
        cfg.options().copyDefaults(true);
        cfg.set("joinmessage", message);
        try {
            cfg.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        readNormalConfig();
    }

    public static void setLeaveMessage(String message) {
        FileConfiguration cfg = getConfigFileConfig();
        cfg.options().copyDefaults(true);
        cfg.set("leavemessage", message);
        try {
            cfg.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        readNormalConfig();
    }
}
