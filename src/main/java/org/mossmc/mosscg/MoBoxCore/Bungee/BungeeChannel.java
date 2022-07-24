package org.mossmc.mosscg.MoBoxCore.Bungee;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.mossmc.mosscg.MoBoxCore.Main;

public class BungeeChannel implements PluginMessageListener {
    public static void initBungeeChannel() {
        Bukkit.getMessenger().registerOutgoingPluginChannel(Main.instance, Main.getConfig.getString("bungeeChannel"));
        Bukkit.getMessenger().registerIncomingPluginChannel(Main.instance, Main.getConfig.getString("bungeeChannel"), new BungeeChannel());
    }

    @Override
    public void onPluginMessageReceived(String string, Player player, byte[] message) {

    }
}
