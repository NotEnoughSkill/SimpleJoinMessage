package me.NotEnoughSkill.SimpleJoinMessage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveMessage implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().toggle.booleanValue()) {
            e.setQuitMessage(Main.getInstance().leaveMessage.replace("{player}", p.getName()));
        } else {e.setQuitMessage("");}
    }
}
