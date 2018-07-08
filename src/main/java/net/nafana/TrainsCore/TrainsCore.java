package net.nafana.TrainsCore;

import net.nafana.TrainsCore.commands.SpawnTrainCommand;
import net.nafana.TrainsCore.data.ConfigurationFetcher;
import net.nafana.TrainsCore.data.PlayerPermission;
import net.nafana.TrainsCore.data.configurations.TrainPartsConfiguration;
import net.nafana.TrainsCore.events.ButtonClickEvent;
import net.nafana.TrainsCore.generation.TrainsLoader;
import net.nafana.TrainsCore.gui.GUI;
import net.nafana.TrainsCore.gui.GUIManager;
import net.nafana.TrainsCore.gui.buttons.Button;
import net.nafana.TrainsCore.gui.buttons.IButtonAction;
import net.nafana.TrainsCore.gui.buttons.types.PermissionButton;
import net.nafana.TrainsCore.items.TrainPart;
import net.nafana.TrainsCore.listeners.*;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class TrainsCore extends JavaPlugin {

    /** Singleton instances of the public classes **/
    private static TrainsLoader trainsLoader;
    private static TrainsCore trainsCore;
    private static ConfigurationFetcher configFetcher;
    private static GUIManager guiManager;

    private final static String schematicsFolderName = "\\trainparts_schematics";

    // Ran when the plugin is enabled
    public void onEnable() {
        trainsCore = this;
        registerConfig();
        registerExternalConfigs();
        registerCommands();
        registerListeners();
        initTrainsLoader();
        registerGUIManager();
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
        if (!(trainParts == null)) {
            for (TrainPart part : trainParts) {
                trainsLoader.addTrainPart(part);
            }
        }
    }

    /** Registers the commands for the TrainsCore plugin **/
    private void registerCommands() {
        this.getCommand("spawntrain").setExecutor(new SpawnTrainCommand());
    }

    /** Registers the Listeners for the TrainsCore plugin **/
    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryDragItemListener(), this);
        this.getServer().getPluginManager().registerEvents(new ButtonClickListener(), this);
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

    private void registerGUIManager() {
        //TODO: Implement registration for the GUIManager
        guiManager = new GUIManager();
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

    /** Allows you to get the singleton instance of the GUIManager **/
    public static GUIManager getGuiManager() {return guiManager; }

    public static String schematicsResourceFolderName() {
        return schematicsFolderName;
    }

}
