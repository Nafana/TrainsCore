package net.nafana.TrainsCore;

import net.nafana.TrainsCore.commands.SpawnTrainCommand;
import net.nafana.TrainsCore.generation.TrainsLoader;
import net.nafana.TrainsCore.items.TrainModel;
import net.nafana.TrainsCore.items.trainparts.types.TrainPartPilot;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class TrainsCore extends JavaPlugin {

    /** Singleton instance of the TrainsLoader class **/
    private static TrainsLoader trainsLoader;
    private static TrainsCore trainsCore;

    private final static String schematicsFolderName = "\\trainparts_schematics";

    // Ran when the plugin is enabled
    public void onEnable() {
        trainsCore = this;
        registerConfig();
        registerCommands();
        initTrainsLoader();
        getLogger().log(Level.FINE, "Plugin Class has initialized, everything working correctly!");
    }

    // Ran when the plugin is disabled
    public void onDisable () {

    }

    /** TODO: replace this method with a file lookup to generate all the trains parts **/
    private void initTrainsLoader() {
        trainsLoader = new TrainsLoader();
        trainsLoader.addTrainPart(new TrainPartPilot(
                "test", TrainModel.TIER_1_STEAM, 20.0f
        ));
    }

    /** Registers the commands for the TrainsCore plugin **/
    private void registerCommands() {
        this.getCommand("spawntrain").setExecutor(new SpawnTrainCommand());
    }

    private void registerConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        if (getDataFolder() != null) {
            // Makes sure the schematics folder is present in our data folder
            File schematicsFolder = new File(getDataFolder().getPath() + schematicsFolderName);

            // If the schematic folder does not exist, we want to make the directory for it!
            if (!schematicsFolder.exists()) {
                schematicsFolder.mkdirs();
            }
        }

    }

    /** Allows you to get the singleton instance of the TrainsLoader **/
    public static TrainsLoader getTrainsLoader() {
        return trainsLoader;
    }

    /** Allows you to get the singleton instance of the TrainsCore **/
    public static TrainsCore getTrainsCore() {
        return trainsCore;
    }

    public static String schematicsResourceFolderName() {
        return schematicsFolderName;
    }

}
