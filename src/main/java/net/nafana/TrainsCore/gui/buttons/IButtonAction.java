package net.nafana.TrainsCore.gui.buttons;

import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * The interface Button action.
 *
 * @author Created by Nafana on 2018-07-11
 */
public interface IButtonAction {

    /**
     * Do action.
     *
     * @param event the event
     */
// Tells the button to do a certain action
    void doAction(InventoryClickEvent event);

}
