package org.mossmc.mosscg.MoBoxCore.Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.mossmc.mosscg.MoBoxCore.Game.GameBasicInfo;
import org.mossmc.mosscg.MoBoxCore.Game.GameStatus;

public class ListenerPing implements Listener {
    @EventHandler
    public static void onPing(ServerListPingEvent event) {
        GameStatus.gameStatus status = GameBasicInfo.gameStatus;
        switch (status) {
            case Waiting:
                event.setMaxPlayers(GameBasicInfo.getGame.maxPlayer());
                break;
            case Starting:
            case Running:
            case Ending:
                event.setMaxPlayers(Bukkit.getOnlinePlayers().size());
        }
        event.setMotd(status.name());
    }
}
