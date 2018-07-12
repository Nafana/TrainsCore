package net.nafana.TrainsCore.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Nafana on 2018-07-03.
 */
public final class ConfigurationFetcher {

    private List<Configuration> configurations = new ArrayList<>();

    /**
     * Instantiates a new Configuration fetcher.
     */
    public ConfigurationFetcher () {}

    /**
     * Add configuration.
     *
     * @param config the config
     */
    public void addConfiguration(Configuration config) {
        this.configurations.add(config);
    }

    /**
     * Remove configuration.
     *
     * @param config the config
     */
    public void removeConfiguration(Configuration config) {
        this.configurations.remove(config);
    }

    /**
     * Gets configuration by name.
     *
     * @param configurationName the configuration name
     * @return the configuration by name
     */
    public Configuration getConfigurationByName(String configurationName) {
        for (Configuration config : configurations) {
            if (config.getConfigurationName().equals(configurationName)) {
                return config;
            }
        }
        return null;
    }

}
