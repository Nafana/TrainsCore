package net.nafana.TrainsCore.gui;

public interface Buildable {

    // TileBuilder instance
    TileBuilder builder = new TileBuilder();

    // Create a build method for a GUI class
    GUI build();

}
