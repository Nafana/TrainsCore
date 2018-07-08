package net.nafana.TrainsCore.events;

import net.nafana.TrainsCore.gui.buttons.Button;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ButtonClickEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private InventoryClickEvent event;
    private Button buttonClicked;
    private boolean cancelled;

    public ButtonClickEvent (InventoryClickEvent event, Button buttonClicked) {
        this.event = event;
        this.buttonClicked = buttonClicked;
    }

    public InventoryClickEvent getInventoryClickEvent() {
        return this.event;
    }

    public Button getButtonClicked() {
        return this.buttonClicked;
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
