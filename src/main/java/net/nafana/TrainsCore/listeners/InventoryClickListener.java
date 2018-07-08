package net.nafana.TrainsCore.listeners;

import net.nafana.TrainsCore.TrainsCore;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class  InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getClick() != null) {
            TrainsCore.getGuiManager().broadcastInventoryClickEvent(e);
        }
    }

}
