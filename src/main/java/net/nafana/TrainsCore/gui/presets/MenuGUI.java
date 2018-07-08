package net.nafana.TrainsCore.gui.presets;

import net.nafana.TrainsCore.gui.GUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuGUI {

    public static GUI build() {

        GUI menu = new GUI(3, ChatColor.DARK_PURPLE + "Menu");

        ItemStack head = new ItemStack(Material.SKULL);
        addLore(head,
                ChatColor.GRAY + "Player Stats and Information:",
                ChatColor.GOLD + "Rank: " + ChatColor.BOLD + "RANK",
                ChatColor.AQUA + "In Game Time: TIME",
                ChatColor.RED + "Total Kills: KILLS",
                ChatColor.DARK_RED + "Total Deaths: DEATHS");
        setName(head, "PLAYER's Stats");

        menu.setItemAtIndex(head, 10);

        return menu;
    }

    private static void addLore(ItemStack item, String... lines) {

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>(Arrays.asList(lines));
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    private static void setName(ItemStack item, String name) {

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);

    }
}
