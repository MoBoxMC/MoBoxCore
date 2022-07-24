package org.mossmc.mosscg.MoBoxCore.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.mossmc.mosscg.MoBoxCore.Bungee.BungeeTeleport;

public class ListenerInventoryClick implements Listener {
    //这个东西还有亿点点BUG，懒得修了
    @EventHandler
    public static void onClick(InventoryClickEvent event) {
        Material material = event.getCurrentItem().getType();
        if (event.getCurrentItem().getItemMeta().getLore() == null) {
            return;
        }
        if (!event.getCurrentItem().getItemMeta().getLore().contains("MoBoxMC")) {
            return;
        }
        switch (material) {
            case BOOK:
                BungeeTeleport.backLobbyTeleport((Player) event.getWhoClicked());
                event.setCancelled(true);
                break;
            case PAPER:
                BungeeTeleport.nextGameTeleport((Player) event.getWhoClicked());
                event.setCancelled(true);
                break;
            default:
                break;
        }
    }
}
