package net.nafana.TrainsCore.listeners;

import net.nafana.TrainsCore.TrainsCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

/**
 * @author Created by Nafana on 2018-07-08.
 */
public class InventoryDragItemListener implements Listener {

    /**
     * On drag item event.
     *
     * @param event the event
     */
    @EventHandler
    public void onDragItemEvent(InventoryDragEvent event) {
        TrainsCore.getGuiManager().broadcastInventoryClickEvent(event);
    }
}
