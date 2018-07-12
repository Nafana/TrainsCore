package net.nafana.TrainsCore.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

/**
 * The type Gui display event.
 *
 * @author Created by Nafana on 2018-07-11
 */
public class GUIDisplayEvent  extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private InventoryOpenEvent event;
    private Inventory inventory;
    private boolean cancelled;

    /**
     * Instantiates a new Gui display event.
     *
     * @param event     the event
     * @param inventory the inventory
     */
    public GUIDisplayEvent (InventoryOpenEvent event, Inventory inventory) {
        this.event = event;
        this.inventory = inventory;
    }

    /**
     * Gets handler list.
     *
     * @return the handler list
     */
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * Gets inventory open event.
     *
     * @return the inventory open event
     */
    public InventoryOpenEvent getInventoryOpenEvent() {
        return this.event;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Gets gui.
     *
     * @return the gui
     */
    public Inventory getGUI() {
        return this.inventory;
    }
}
