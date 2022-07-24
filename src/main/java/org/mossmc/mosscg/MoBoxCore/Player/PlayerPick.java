package org.mossmc.mosscg.MoBoxCore.Player;

import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class PlayerPick {
    public static void disablePickUp(Player player) {
        player.setCanPickupItems(false);
    }

    public static void enablePickUp(Player player) {
        player.setCanPickupItems(true);
    }
}
