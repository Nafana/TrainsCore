package net.nafana.TrainsCore.listeners;

import net.nafana.TrainsCore.TrainsCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

/**
 * The type Inventory open listener.
 *
 * @author Created by Nafana on 2018-07-11
 */
public class InventoryOpenListener implements Listener {

    // Will be used to pass Player into GUI for names and stats

    /**
     * On inventory opened.
     *
     * @param e the event when the inventory is opened
     */
    @EventHandler
    public void onInventoryOpened(InventoryOpenEvent e) {

        if(TrainsCore.getGuiManager().getGUIByName(e.getInventory().getTitle()) != null) {
            //TODO: broadcast GUIDisplayEvent
        }
    }
}
