package net.nafana.TrainsCore.commands.debug;

import net.nafana.TrainsCore.TrainsCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * GUI debug command for testing
 *
 * @author Created by GrimlyTwisted on 2018-07-11
 */
public class GUIDebugCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.isOp() && sender instanceof Player) {

            Player player = (Player) sender;

            TrainsCore.getGuiManager().getGUIByName("DebugGUI").showPlayerInventory(player);

            //player.sendMessage(ChatColor.RED + "Debug option has not been implemented yet!");

        }
        return true;
    }
}
