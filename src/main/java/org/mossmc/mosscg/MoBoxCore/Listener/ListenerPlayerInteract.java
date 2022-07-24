package org.mossmc.mosscg.MoBoxCore.Listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.mossmc.mosscg.MoBoxCore.Bungee.BungeeTeleport;

public class ListenerPlayerInteract implements Listener {
    //这个东西还有亿点点BUG，懒得修了
    @EventHandler
    public static void onInteract(PlayerInteractEvent event) {
        Material material = event.getMaterial();
        switch (material) {
            case BOOK:
                if (event.getItem().getItemMeta().getLore().contains("MoBoxMC")) {
                    BungeeTeleport.backLobbyTeleport(event.getPlayer());
                }
                event.setCancelled(true);
                break;
            case PAPER:
                if (event.getItem().getItemMeta().getLore().contains("MoBoxMC")) {
                    BungeeTeleport.nextGameTeleport(event.getPlayer());
                }
                event.setCancelled(true);
                break;
            default:
                break;
        }
    }
}
