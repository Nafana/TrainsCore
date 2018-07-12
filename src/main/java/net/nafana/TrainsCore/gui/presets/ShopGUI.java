package net.nafana.TrainsCore.gui.presets;

import net.nafana.TrainsCore.data.PlayerPermission;
import net.nafana.TrainsCore.gui.Buildable;
import net.nafana.TrainsCore.gui.GUI;
import net.nafana.TrainsCore.gui.buttons.types.EconomyButton;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Creates the Shop GUI for players in the game
 *
 * @author Created by GrimlyTwisted on 2018-07-011
 */
public class ShopGUI implements Buildable {

    /**
     * Builds and returns a GUI on build method called
     *
     * @return GUI that is built
     */
    @Override
    public GUI build() {

        GUI gui = new GUI(6, ChatColor.GOLD + "Shop");

        ItemStack balance = new ItemStack(Material.EMERALD); // Tile
        ItemStack previous = new ItemStack(Material.SIGN); // Button
        ItemStack next = new ItemStack(Material.SIGN); // Button

        builder.setDisplayName(balance, ChatColor.GREEN + "Balance: BALANCE");
        builder.setDisplayName(previous, "<- Previous Page");
        builder.setDisplayName(next, "Next Page ->");

        builder.setLore(previous,
                "",
                "Sends you back to the previous",
                "page in the shop GUI.");

        builder.setLore(next,
                "",
                "Sends you to the next",
                "page in the shop GUI.");

        gui.setItemAtIndex(balance, 4);

        gui.setItemAtIndex(new EconomyButton(previous, event ->
                event.getWhoClicked().sendMessage("Woops! Cannot go to previous page!"), PlayerPermission.BUY_ITEM), 45);

        gui.setItemAtIndex(new EconomyButton(next, event ->
                event.getWhoClicked().sendMessage("Woops! Cannot go to next page!"), PlayerPermission.BUY_ITEM), 53);

        gui.fillRect(new ItemStack(Material.STAINED_GLASS), 9, 43);

        return gui;

    }
}
