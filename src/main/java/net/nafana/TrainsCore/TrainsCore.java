package net.nafana.TrainsCore;

import net.nafana.TrainsCore.commands.SpawnTrainCommand;
import net.nafana.TrainsCore.data.ConfigurationFetcher;
import net.nafana.TrainsCore.data.configurations.TrainPartsConfiguration;
import net.nafana.TrainsCore.generation.TrainsLoader;
import net.nafana.TrainsCore.items.TrainPart;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;
import java.util.logging.Level;

public class TrainsCore extends JavaPlugin {

    /** Singleton instances of the public classes **/
    private static TrainsLoader trainsLoader;
    private static TrainsCore trainsCore;
    private static ConfigurationFetcher configFetcher;

    private final static String schematicsFolderName = "\\trainparts_schematics";

    // Ran when the plugin is enabled
    public void onEnable() {
        trainsCore = this;
        registerConfig();
        registerExternalConfigs();
        registerCommands();
        initTrainsLoader();
        getLogger().log(Level.FINE, "Plugin Class has initialized, everything working correctly!");
    }

    // Ran when the plugin is disabled
    public void onDisable () {

    }

    private void initTrainsLoader() {
        trainsLoader = new TrainsLoader();
        TrainPartsConfiguration trainConfig =
                (TrainPartsConfiguration) configFetcher.getConfigurationByName("trainparts");
        if (trainConfig == null)
            return;
        List<TrainPart> trainParts = trainConfig.getTrainParts();
        for (TrainPart part : trainParts) {
            trainsLoader.addTrainPart(part);
        }
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

    /** Registers non default configuration files, such as JSON or XML **/
    private void registerExternalConfigs() {
        configFetcher = new ConfigurationFetcher();
        configFetcher.addConfiguration(new TrainPartsConfiguration());
    }

    /** Allows you to get the singleton instance of the TrainsLoader **/
    public static TrainsLoader getTrainsLoader() {
        return trainsLoader;
    }

    /** Allows you to get the singleton instance of the TrainsCore **/
    public static TrainsCore getTrainsCore() {
        return trainsCore;
    }

    /** Allows you to get the singleton instance of the ConfigurationFetcher **/
    public static ConfigurationFetcher getConfigFetcher() {return configFetcher;}

    public static String schematicsResourceFolderName() {
        return schematicsFolderName;
    }

}
