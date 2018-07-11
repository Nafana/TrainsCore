package net.nafana.TrainsCore.gui;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nafana on 2018-07-07.
 */
public class GUIManager {

    private HashMap<String, GUI> guiCache;

    public GUIManager() {
        guiCache = new HashMap<>();
    }

    public GUIManager(HashMap<String, GUI> guiMap) {
        this.guiCache = guiMap;
    }

    public GUI getGUIByName(String guiTag) {
        if (this.guiCache.containsKey(guiTag)) {
            return this.guiCache.get(guiTag);
        } else {
            return null;
        }
    }

    public boolean hasGUI(String guiTag) {
        return this.guiCache.containsKey(guiTag);
    }

    public void addGUI(GUI gui, String guiTag) {
        this.guiCache.put(guiTag, gui);
    }

    public void removeGUI(String guiTag) {
        this.guiCache.remove(guiTag);
    }

    public HashMap<String, GUI> getGuiCache() {
        return this.guiCache;
    }

    public void broadcastInventoryClickEvent(InventoryClickEvent event) {
        for (Map.Entry<String, GUI> entry : this.guiCache.entrySet())
        {
            if (!(event.getClickedInventory() == null)) {
                if (entry.getValue().getGuiName().equals(event.getView().getTopInventory().getTitle())) {
                    // Cancel the click event players should not be able to grab items from the inventory.
                    event.setCancelled(true);
                    entry.getValue().handleClick(event);
                }
            }
        }
    }

    public void broadcastInventoryClickEvent(InventoryDragEvent event) {
        for (Map.Entry<String, GUI> entry : this.guiCache.entrySet())
        {
            if (event.getView().getTopInventory() != null) {
                if (entry.getValue().getGuiName().equals(event.getView().getTopInventory().getTitle())) {
                    event.setCancelled(true);
                }
            }
        }
    }

}
