package org.mossmc.mosscg.MoBoxCore.Info;

import org.bukkit.ChatColor;

public class InfoCountDown {
    public static String getRemainSecondString(int second) {
        //11-正无穷 绿色
        if (second > 10) {
            return ChatColor.GREEN+String.valueOf(second);
        }
        //6-10 蓝色
        if (second > 5) {
            return ChatColor.AQUA+String.valueOf(second);
        }
        //5-4 黄色
        if (second > 3) {
            return ChatColor.YELLOW+String.valueOf(second);
        }
        //负无穷-3 红色
        return ChatColor.RED+String.valueOf(second);
    }
}
