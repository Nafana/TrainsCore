package net.nafana.TrainsCore.gui;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Tile builder.
 *
 * @author Created by GrimlyTwisted on 2018-07-11
 */
public class TileBuilder {

    /**
     * Sets lore.
     *
     * @param item  the item
     * @param lines the lines
     */
    public void setLore(ItemStack item, String... lines) {

        List<String> lore = new ArrayList<>();
        for(String line : lines) {
            lore.add(ChatColor.translateAlternateColorCodes('&', line));
        }
        ItemMeta meta = item.getItemMeta();

        meta.setLore(lore);
        item.setItemMeta(meta);

    }

    /**
     * Sets display name.
     *
     * @param item the item
     * @param name the name
     */
    public void setDisplayName(ItemStack item, String name) {

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        item.setItemMeta(meta);

    }
}
