package org.mossmc.mosscg.MoBoxCore.Player;

import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class PlayerDamage {
    public static void setNoDamageTick(Player player, int tick) {
        player.setNoDamageTicks(tick);
    }
}
