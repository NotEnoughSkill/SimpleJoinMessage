package me.NotEnoughSkill.SimpleJoinMessage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class KickMessage implements Listener {
    @EventHandler
    public void onKick (PlayerKickEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().toggle.booleanValue()) {
            e.setLeaveMessage(Main.getInstance().leaveMessage.replace("{player}", p.getName()));
        } else {
            e.setLeaveMessage("");
        }
    }
}
