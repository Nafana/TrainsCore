package net.nafana.TrainsCore.gui;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * The GUIManager class caches in game inventories and allows you to get any GUI you want by its tag.
 * @author  Created by Nafana on 2018-07-07.
 **/
public class GUIManager {

    /**
     * The GUI cache data structure, a HashMap which has the GUI string tag as the key, and the GUI
     * itself as the entry.
     */
    private HashMap<String, GUI> guiCache;

    /**
     * Initializes the GUI manager object with no GUIs.
     */
    public GUIManager() {
        guiCache = new HashMap<>();
    }

    /**
     * Initializes the GUI manager with an already existing cache.
     * @param guiMap the ready to use GUI cache
     */
    public GUIManager(HashMap<String, GUI> guiMap) {
        this.guiCache = guiMap;
    }

    /**
     * Gets the GUI by its String tag, assigned during initialization.
     * @param guiTag The tag for the GUI used to find it in the cache.
     */
    public GUI getGUIByName(String guiTag) {
        if (this.guiCache.containsKey(guiTag)) {
            return this.guiCache.get(guiTag);
        } else {
            return null;
        }
    }

    /**
     * Checks if the GUI exists in the cache by its tag.
     * @param guiTag The tag for the GUI used to find it in the cache.
     * @return Returns true if the GUI exists in the cache by tag.
     */
    public boolean hasGUI(String guiTag) {
        return this.guiCache.containsKey(guiTag);
    }

    /**
     * Adds a GUI object to the cache.
     * @param gui The GUI object to add to the cache.
     * @param guiTag The tag for the GUI used to find it in the cache.
     */
    public void addGUI(GUI gui, String guiTag) {
        this.guiCache.put(guiTag, gui);
    }

    /**
     * Removes a GUI object from the cache.
     * @param guiTag The tag for the GUI used to find it in the cache.
     */
    public void removeGUI(String guiTag) {
        this.guiCache.remove(guiTag);
    }

    /**
     * Returns the full GUI cache.
     * @return Returns a HashMap with the key being the String tag, and the entry being the GUI object.
     */
    public HashMap<String, GUI> getGuiCache() {
        return this.guiCache;
    }

    /**
     * Notifies the GUI that a click happened.
     * @param event The InventoryClickEvent that took place in the inventory.
     */
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

    /**
     * Notifies the GUI that a click happened.
     * @param event The InventoryDragEvent that took place in the inventory.
     */
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
