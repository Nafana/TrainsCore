package net.nafana;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class TrainsCore extends JavaPlugin {

    public void onEnable() {
        getLogger().log(Level.FINE, "Plugin Class has initialized, everything working correctly!");
    }

    public void onDisable () {

    }

}
