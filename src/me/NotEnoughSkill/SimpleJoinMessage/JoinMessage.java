package me.NotEnoughSkill.SimpleJoinMessage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().toggle.booleanValue()) {
            e.setJoinMessage(Main.getInstance().joinMessage.replace("{player}", p.getName()));
        } else {
            e.setJoinMessage("");
        }
    }
}
