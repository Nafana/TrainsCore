package net.nafana.TrainsCore.commands.debug;

import net.nafana.TrainsCore.TrainsCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
