package net.nafana.TrainsCore.listeners;

import net.nafana.TrainsCore.events.ButtonClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        Bukkit.getServer().getPluginManager().callEvent(new ButtonClickEvent(
                e.getView(),
                e.getSlotType(),
                e.getSlot(),
                e.getClick(),
                e.getAction()
        ));
    }
}
