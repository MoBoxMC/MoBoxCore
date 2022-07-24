package org.mossmc.mosscg.MoBoxCore.Chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.*;

@SuppressWarnings("unused")
public class ChatChannel {
    //是否使用频道聊天
    public static boolean useChannelChat = false;
    //玩家聊天信息格式
    public static Map<UUID,String> playerPrefixMap = new HashMap<>();
    public static Map<UUID,ChatColor> playerChatColorMap = new HashMap<>();
    //这包含在该频道内的所有玩家
    public static Map<String,List<UUID>> chatChannelMap = new HashMap<>();
    //这包含该频道内玩家所能发送到的其它频道
    public static Map<String,List<String>> chatCopyChannelMap = new HashMap<>();

    public static void resetPlayerChat(UUID uuid) {
        playerPrefixMap.remove(uuid);
        playerChatColorMap.remove(uuid);
        chatChannelMap.forEach((channel, playerList) -> playerList.remove(uuid));
    }

    public static void addChannel(String channel) {
        chatChannelMap.put(channel,new ArrayList<>());
        chatCopyChannelMap.put(channel,new ArrayList<>());
    }

    public static List<Player> getPlayerReceiver(UUID sender) {
        List<Player> receiver = new ArrayList<>();
        List<String> channelList = ChatChannel.getPlayerChatChannel(sender);
        //首先对玩家的所有channel进行遍历
        channelList.forEach(channel -> {
            //将玩家本身channel里面的玩家无重复的放入集合
            ChatChannel.chatChannelMap.get(channel).forEach(uuid -> {
                Player player = Bukkit.getPlayer(uuid);
                if (player != null && !receiver.contains(player)) {
                    receiver.add(player);
                }
            });
            //再获取该channel抄送的channel
            List<String> copyChannelList = getChatCopyChannel(channel);
            //如果有，无重复的放入集合
            if (copyChannelList != null) {
                //对每个抄送的集合操作
                copyChannelList.forEach(copyChannel ->
                        //无重复的放入
                        ChatChannel.chatChannelMap.get(copyChannel).forEach(uuid -> {
                            Player player = Bukkit.getPlayer(uuid);
                            if (player != null && !receiver.contains(player)) {
                                receiver.add(player);
                            }
                        })
                );
            }
        });
        return receiver;
    }

    public static void addPlayerChatChannel(UUID uuid, String channel) {
        if (!chatChannelMap.containsKey(channel)) {
            chatChannelMap.put(channel,new ArrayList<>());
        }
        if (!chatChannelMap.get(channel).contains(uuid)) {
            chatChannelMap.get(channel).add(uuid);
        }
    }

    public static List<String> getPlayerChatChannel(UUID uuid) {
        List<String> list = new ArrayList<>();
        chatChannelMap.forEach((channel, playerList) -> {
            if (playerList.contains(uuid)) {
                list.add(channel);
            }
        });
        return list;
    }

    public static void setChatCopyChannel(String from, String to) {
        if (chatCopyChannelMap.containsKey(from)) {
            if (!chatCopyChannelMap.get(from).contains(to)) {
                chatCopyChannelMap.get(from).add(to);
            }
        } else {
            List<String> list = new ArrayList<>();
            list.add(to);
            chatCopyChannelMap.put(from,list);
        }
    }

    public static List<String> getChatCopyChannel(String channel) {
        return chatCopyChannelMap.get(channel);
    }

    public static void setPlayerChatPrefix(UUID uuid,String prefix) {
        playerPrefixMap.put(uuid, prefix);
    }
    public static String getPlayerChatPrefix(UUID uuid) {
        return playerPrefixMap.getOrDefault(uuid, ChatColor.GRAY+"");
    }

    public static void setPlayerChatColor(UUID uuid,ChatColor color) {
        playerChatColorMap.put(uuid,color);
    }
    public static ChatColor getPlayerChatColor(UUID uuid) {
        return playerChatColorMap.getOrDefault(uuid, ChatColor.GRAY);
    }
}
