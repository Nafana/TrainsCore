package net.nafana.TrainsCore.commands.gui;

import net.nafana.TrainsCore.TrainsCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * The type Player shop.
 *
 * @author Created by GrimlyTwisted on 2018-07-11
 */
public class PlayerShop implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player player = (Player) sender;
            TrainsCore.getGuiManager().getGUIByName("Shop").showPlayerInventory(player);

        }

        return true;
    }
}