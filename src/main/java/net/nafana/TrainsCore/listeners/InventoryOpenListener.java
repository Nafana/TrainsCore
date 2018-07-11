package net.nafana.TrainsCore.listeners;

import net.nafana.TrainsCore.TrainsCore;
import net.nafana.TrainsCore.events.GUIDisplayEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class InventoryOpenListener implements Listener {

    // Will be used to pass Player into GUI for names and stats

    @EventHandler
    public void onInventoryOpened(InventoryOpenEvent e) {

        if(TrainsCore.getGuiManager().getGUIByName(e.getInventory().getTitle()) != null) {
            //TODO: broadcast GUIDisplayEvent
        }
    }
}
