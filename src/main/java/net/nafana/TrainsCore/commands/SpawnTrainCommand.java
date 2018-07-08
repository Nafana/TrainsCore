package net.nafana.TrainsCore.commands;

import net.nafana.TrainsCore.TrainsCore;
import net.nafana.TrainsCore.gui.GUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Nafana on 2018-07-03.
 */
public class SpawnTrainCommand implements CommandExecutor {

    /** This command spawns in a train, this is strictly a debug command. **/
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length == 1) {

            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage("This command cannot be called from console.");
                return true;
            }

            Player player = (Player) commandSender;
            TrainsCore.getTrainsLoader().spawnTrainPart(
                    args[0], player.getLocation(), true
            );
            return true;
        } else {
            commandSender.sendMessage("Not valid command usage, try: /spawntrain <TRAIN_NAME>");
            return true;
        }
    }

}
