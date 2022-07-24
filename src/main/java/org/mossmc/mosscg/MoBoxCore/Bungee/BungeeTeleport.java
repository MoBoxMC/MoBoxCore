package org.mossmc.mosscg.MoBoxCore.Bungee;

import org.bukkit.entity.Player;
import org.mossmc.mosscg.MoBoxCore.Game.GameBasicInfo;
import org.mossmc.mosscg.MoBoxCore.Main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

@SuppressWarnings("unused")
public class BungeeTeleport {
    public static void nextGameTeleport(Player player) {
        teleport(player, GameBasicInfo.getGame.gameServerNext());
    }

    public static void backLobbyTeleport(Player player) {
        teleport(player, GameBasicInfo.getGame.gameServerLobby());
    }

    public static void teleport(Player player, String serverName) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeUTF("ConnectOther");
            dataOutputStream.writeUTF(player.getName());
            dataOutputStream.writeUTF(serverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(Main.instance, Main.getConfig.getString("bungeeChannel"), byteArrayOutputStream.toByteArray());
    }
}
