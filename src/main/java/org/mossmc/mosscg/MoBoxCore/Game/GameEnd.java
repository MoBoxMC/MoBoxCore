package org.mossmc.mosscg.MoBoxCore.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;
import org.mossmc.mosscg.MoBoxCore.Bungee.BungeeChannel;
import org.mossmc.mosscg.MoBoxCore.Bungee.BungeeTeleport;
import org.mossmc.mosscg.MoBoxCore.Listener.ListenerInventoryClick;
import org.mossmc.mosscg.MoBoxCore.Listener.ListenerPlayerInteract;
import org.mossmc.mosscg.MoBoxCore.Main;

public class GameEnd {
    public static void startEnd() {
        boolean gameEndServerTeleport = GameBasicInfo.getGame.gameEndServerTeleport();
        if (gameEndServerTeleport) {
            BungeeChannel.initBungeeChannel();
            Bukkit.getPluginManager().registerEvents(new ListenerPlayerInteract(), Main.instance);
            Bukkit.getPluginManager().registerEvents(new ListenerInventoryClick(), Main.instance);
        }
        if (gameEndServerTeleport) {
            Bukkit.broadcastMessage(ChatColor.YELLOW+"游戏已结束！20秒后将自动匹配下一场游戏！");
        } else {
            Bukkit.broadcastMessage(ChatColor.YELLOW+"游戏已结束！服务器将在30秒后重启！");
        }
        new BukkitRunnable(){
            @Override
            public void run() {
                if (gameEndServerTeleport) {
                    Bukkit.broadcastMessage(ChatColor.YELLOW+"游戏已结束！10秒后将自动匹配下一场游戏！");
                } else {
                    Bukkit.broadcastMessage(ChatColor.YELLOW+"游戏已结束！服务器将在20秒后重启！");
                }
            }
        }.runTaskLater(Main.instance,20*10);
        new BukkitRunnable(){
            @Override
            public void run() {
                if (gameEndServerTeleport) {
                    Bukkit.broadcastMessage(ChatColor.GREEN+"正在匹配下一场游戏......");
                } else {
                    Bukkit.broadcastMessage(ChatColor.YELLOW+"游戏已结束！服务器将在10秒后重启！");
                }
                Bukkit.getOnlinePlayers().forEach(player -> {
                    if (gameEndServerTeleport) {
                        BungeeTeleport.nextGameTeleport(player);
                    }
                });
            }
        }.runTaskLater(Main.instance,20*20);
        new BukkitRunnable(){
            @Override
            public void run() {
                if (gameEndServerTeleport) {
                    Bukkit.broadcastMessage(ChatColor.GREEN+"正在匹配下一场游戏......");
                } else {
                    Bukkit.broadcastMessage(ChatColor.RED+"游戏已结束！服务器将在5秒后重启！");
                }
            }
        }.runTaskLater(Main.instance,20*25);
        new BukkitRunnable(){
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.kickPlayer(ChatColor.GREEN + "游戏已结束！你已被强制返回大厅服务器！");
                });
                Bukkit.shutdown();
            }
        }.runTaskLater(Main.instance,20*30);
    }
}
