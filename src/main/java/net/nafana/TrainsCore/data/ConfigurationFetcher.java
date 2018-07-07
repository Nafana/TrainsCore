package net.nafana.TrainsCore.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nafana on 2018-07-03.
 */
public final class ConfigurationFetcher {

    private List<Configuration> configurations = new ArrayList<>();

    public ConfigurationFetcher () {}

    public void addConfiguration(Configuration config) {
        this.configurations.add(config);
    }

    public void removeConfiguration(Configuration config) {
        if (this.configurations.contains(config)) {
            this.configurations.remove(config);
        }
    }

    public Configuration getConfigurationByName(String configurationName) {
        for (Configuration config : configurations) {
            if (config.getConfigurationName().equals(configurationName)) {
                return config;
            }
        }
        return null;
    }

}
