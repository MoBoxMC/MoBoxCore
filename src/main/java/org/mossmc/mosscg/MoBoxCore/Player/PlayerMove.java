package org.mossmc.mosscg.MoBoxCore.Player;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
public class PlayerMove {
    //使用此功能需要先注册ListenerMove监听器
    public static boolean canAllMove = true;

    public static List<UUID> disableMoveList = new ArrayList<>();

    public static void disableMove(Player player) {
        disableMoveList.add(player.getUniqueId());
    }

    public static void enableMove(Player player) {
        disableMoveList.remove(player.getUniqueId());
    }

    public static void disableAllMove() {
        canAllMove = false;
    }

    public static void enableAllMove() {
        disableMoveList.clear();
        canAllMove = true;
    }
}
