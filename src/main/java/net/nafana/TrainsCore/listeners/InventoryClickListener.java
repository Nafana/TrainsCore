package net.nafana.TrainsCore.listeners;

import net.nafana.TrainsCore.TrainsCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * The type Inventory click listener.
 *
 * @author Created by GrimlyTwisted on 2018-07-11
 */
public class  InventoryClickListener implements Listener {

    /**
     * On inventory click.
     *
     * @param e the event passed on inventory click
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getClick() != null) {
            TrainsCore.getGuiManager().broadcastInventoryClickEvent(e);
        }
    }

}
