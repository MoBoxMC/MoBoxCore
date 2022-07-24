package org.mossmc.mosscg.MoBoxCore.Game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;
import org.mossmc.mosscg.MoBoxCore.Info.InfoCountDown;
import org.mossmc.mosscg.MoBoxCore.Main;

@SuppressWarnings("unused")
public class GameWait {
    public static int remainSecond = 30;

    @SuppressWarnings({"deprecation", "unused"})
    public static void startWait() {
        remainSecond = GameBasicInfo.getGame.waitTime();
        new BukkitRunnable() {
            @SuppressWarnings("CodeBlock2Expr")
            @Override
            public void run() {
                GameStatus.gameStatus status = GameBasicInfo.gameStatus;
                if (!status.equals(GameStatus.gameStatus.Waiting)) {
                    cancel();
                    return;
                }
                if (remainSecond <= 0) {
                    try {
                        GameBasicInfo.startMethod.invoke(Main.instance);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }
                int playerNow = Main.instance.getServer().getOnlinePlayers().size();
                if (playerNow < GameBasicInfo.getGame.minPlayer()) {
                    remainSecond = GameBasicInfo.getGame.waitTime();
                    String titleMain = ChatColor.AQUA+String.valueOf(playerNow)+" "+ChatColor.WHITE+"/ "+ChatColor.AQUA+GameBasicInfo.getGame.maxPlayer();
                    String titleSub = ChatColor.GREEN+"正在等待更多玩家加入游戏...";
                    Main.instance.getServer().getOnlinePlayers().forEach(player -> {
                        player.sendTitle(titleMain,titleSub);
                    });
                } else {
                    if (playerNow >= GameBasicInfo.getGame.maxPlayer()) {
                        Bukkit.broadcastMessage(ChatColor.GREEN+"玩家到齐，倒计时缩短！");
                        remainSecond = GameBasicInfo.getGame.reduceTime();
                    }
                    String titleMain = ChatColor.AQUA+String.valueOf(playerNow)+" "+ChatColor.WHITE+"/ "+ChatColor.AQUA+GameBasicInfo.getGame.maxPlayer();
                    String titleSub = ChatColor.GREEN+"游戏即将开始..."+ InfoCountDown.getRemainSecondString(remainSecond);
                    Main.instance.getServer().getOnlinePlayers().forEach(player -> {
                        Sound sound = Sound.valueOf(Main.getConfig.getString("countdownSound"));
                        player.sendTitle(titleMain,titleSub);
                        player.playSound(player.getLocation(),sound,1.0f,1.0f);
                    });
                    remainSecond--;
                }
            }
        }.runTaskTimer(Main.instance, 0, 20);
    }
}
