package org.mossmc.mosscg.MoBoxCore.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemNextGame {
    //这俩有bug，不会修，懒得搞了
    public static ItemStack getItemNextGame() {
        ItemStack itemStack = new ItemStack(Material.PAPER);
        itemStack.setAmount(1);
        itemStack.getItemMeta().setDisplayName("再来一局");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GREEN+"愣着干啥呀");
        lore.add(ChatColor.GREEN+"点它开下一局啊");
        lore.add(ChatColor.DARK_GRAY+"MoBoxMC");
        itemStack.getItemMeta().setLore(lore);
        return itemStack;
    }
}
