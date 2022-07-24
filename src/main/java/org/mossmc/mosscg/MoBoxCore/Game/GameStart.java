package org.mossmc.mosscg.MoBoxCore.Game;

import org.bukkit.Sound;
import org.mossmc.mosscg.MoBoxCore.Main;

@SuppressWarnings("unused")
public class GameStart {
    @SuppressWarnings("all")
    public static void startStart() {
        Main.instance.getServer().getOnlinePlayers().forEach(player -> {
            player.resetTitle();
            Sound sound = Sound.valueOf(Main.getConfig.getString("gameStartSound"));
            player.playSound(player.getLocation(),sound,1.0f,1.0f);
        });
        try {
            GameBasicInfo.runMethod.invoke(Main.instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
