package net.nafana.TrainsCore.gui;

/**
 * Buildable interface for GUI builder classes
 *
 * @author Created by GrimlyTwisted on 2017-07-11
 */
public interface Buildable {

    // TileBuilder instance
    TileBuilder builder = new TileBuilder();

    /**
     * Can be overwritten by implemented classes to build their customized GUI
     *
     * @return GUI that was built
     */
    // Create a build method for a GUI class
    GUI build();

}
