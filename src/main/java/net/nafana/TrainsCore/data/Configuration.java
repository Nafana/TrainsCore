package net.nafana.TrainsCore.data;

import net.nafana.TrainsCore.TrainsCore;

import java.io.File;
import java.io.IOException;

/**
 * Created by Nafana on 2018-07-03.
 */
public abstract class Configuration {

    private final String fileSeparator = "\\";
    private final String dataFolderPath;

    private final String fileName;
    private final String configurationName;

    private File configurationFile;

    public Configuration(String fileName, String configurationName) {
        this.fileName = fileName;
        this.configurationName = configurationName == null ? "" : configurationName;

        if (TrainsCore.getTrainsCore().getDataFolder() != null) {
            this.dataFolderPath = TrainsCore.getTrainsCore().getDataFolder().getPath();
        } else {
            throw new NullPointerException("Data folder for the plugin was not initialized, or has gone missing.");
        }

        File configFile = new File(getConfigurationPath());
        if (!configFile.exists()) {
            try {
                if (!configFile.createNewFile()) {
                    this.configurationFile = null;
                }
            } catch (IOException e) {
                this.configurationFile = null;
            }

        }
    }

    public String getConfigurationPath() {
        return this.dataFolderPath + fileSeparator + this.fileName;
    }

    public String getConfigurationName() {return this.configurationName; }

    public File getConfigurationFile () {
        return this.configurationFile;
    }

}
