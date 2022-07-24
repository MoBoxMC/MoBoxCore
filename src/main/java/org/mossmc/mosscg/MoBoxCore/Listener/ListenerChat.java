package org.mossmc.mosscg.MoBoxCore.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.mossmc.mosscg.MoBoxCore.Chat.ChatChannel;

import java.util.List;
import java.util.UUID;

public class ListenerChat implements Listener {
    //使用这个监听器的话，需要到ChatChannel里头为玩家注册以下内容
    //chatChannel 不注册的话，玩家说话没人听得见
    //chatPrefix 不注册的话，玩家说话就是默认格式
    //chatColor 这个注册不注册影响不大
    @EventHandler
    public static void onChat(AsyncPlayerChatEvent event) {
        if (!ChatChannel.useChannelChat) {
            return;
        }
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        event.getRecipients().clear();
        event.setFormat(ChatChannel.getPlayerChatPrefix(uuid)+event.getPlayer().getDisplayName()+ChatChannel.getPlayerChatColor(uuid)+": "+event.getMessage());
        event.getRecipients().addAll(ChatChannel.getPlayerReceiver(uuid));
    }
}
