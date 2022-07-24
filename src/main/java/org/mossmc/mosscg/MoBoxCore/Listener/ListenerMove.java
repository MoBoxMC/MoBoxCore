package org.mossmc.mosscg.MoBoxCore.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.mossmc.mosscg.MoBoxCore.Player.PlayerMove;

public class ListenerMove implements Listener {
    @SuppressWarnings("all")//掩耳盗铃.jpg
    @EventHandler
    public static void onMove(PlayerMoveEvent event) {
        if (PlayerMove.disableMoveList.contains(event.getPlayer().getUniqueId())) {
            event.getTo().setX(event.getFrom().getX());
            event.getTo().setY(event.getFrom().getY());
            event.getTo().setZ(event.getFrom().getZ());
        }
        if (!PlayerMove.canAllMove) {
            event.getTo().setX(event.getFrom().getX());
            event.getTo().setY(event.getFrom().getY());
            event.getTo().setZ(event.getFrom().getZ());
        }
    }
}
