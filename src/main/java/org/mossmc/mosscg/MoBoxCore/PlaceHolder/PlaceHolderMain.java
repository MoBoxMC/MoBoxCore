package org.mossmc.mosscg.MoBoxCore.PlaceHolder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.mossmc.mosscg.MoBoxCore.Game.GameBasicInfo;

public class PlaceHolderMain extends PlaceholderExpansion {
    @Override
    public String getAuthor() {
        return "MossCG";
    }

    @Override
    public String getIdentifier() {
        return "moboxcore";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        switch (identifier) {
            case "status":
                switch (GameBasicInfo.gameStatus) {
                    case Waiting:
                        return ChatColor.GREEN+"[等待中]";
                    case Starting:
                        return ChatColor.GREEN+"[启动中]";
                    case Running:
                        return ChatColor.GREEN+"[游戏中]";
                    case Ending:
                        return ChatColor.GREEN+"[结束中]";
                    default:
                        return "未知状态";
                }
            case "room":
                String port = String.valueOf(Bukkit.getPort());
                String game = GameBasicInfo.getGame.gameShortName();
                return port+"-"+game;
            default:
                return "未知变量";
        }
    }
}
