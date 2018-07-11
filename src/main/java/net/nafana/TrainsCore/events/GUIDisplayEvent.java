package net.nafana.TrainsCore.events;

import net.nafana.TrainsCore.gui.buttons.Button;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

public class GUIDisplayEvent  extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private InventoryOpenEvent event;
    private Inventory inventory;
    private boolean cancelled;

    public GUIDisplayEvent (InventoryOpenEvent event, Inventory inventory) {
        this.event = event;
        this.inventory = inventory;
    }

    public InventoryOpenEvent getInventoryOpenEvent() {
        return this.event;
    }

    public Inventory getGUI() {
        return this.inventory;
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

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
