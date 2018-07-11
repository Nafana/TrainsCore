package net.nafana.TrainsCore.gui.presets;

import net.nafana.TrainsCore.gui.Buildable;
import net.nafana.TrainsCore.gui.GUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MenuGUI implements Buildable {

    @Override
    public GUI build() {

        GUI gui = new GUI(3, ChatColor.AQUA + "Menu");

        ItemStack profile = new ItemStack(Material.SKULL_ITEM);

        builder.setDisplayName(profile, ChatColor.GREEN + "PLAYER NAME");
        builder.setLore(profile,
                ChatColor.GRAY + "\nPLAYER NAME's stats and information. This ",
                ChatColor.GRAY + "menu can be viewed at any time using /menu\n",
                ChatColor.GOLD + "Rank: RANK",
                ChatColor.AQUA + "In-Game Time: TIME",
                ChatColor.LIGHT_PURPLE + "Trains: AMOUNT",
                ChatColor.RED + "Kills: KILLS",
                ChatColor.DARK_RED + "Deaths: DEATHS"
        );

        gui.setItemAtIndex(profile, 10);

        return gui;
    }
}
