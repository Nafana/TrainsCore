package net.nafana.TrainsCore.listeners;

import net.nafana.TrainsCore.TrainsCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

/**
 * Created by Nafana on 2018-07-08.
 */
public class InventoryDragItemListener implements Listener {

    @EventHandler
    public void onDragItemEvent(InventoryDragEvent event) {
        TrainsCore.getGuiManager().broadcastInventoryClickEvent(event);
    }
}
