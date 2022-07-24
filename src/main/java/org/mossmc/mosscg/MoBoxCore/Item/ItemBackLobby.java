package org.mossmc.mosscg.MoBoxCore.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemBackLobby {
    //这俩有bug，不会修，懒得搞了
    public static ItemStack getItemBackLobby() {
        ItemStack itemStack = new ItemStack(Material.BOOK);
        itemStack.setAmount(1);
        itemStack.getItemMeta().setDisplayName("返回大厅");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN+"别看了");
        lore.add(ChatColor.GREEN+"点我返回大厅");
        itemStack.getItemMeta().setLore(lore);
        return itemStack;
    }
}
