package net.nafana.TrainsCore.events;

import net.nafana.TrainsCore.gui.buttons.Button;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * The type Button click event.
 *
 * @author Created by Nafana on 2018-07-11
 */
public class ButtonClickEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private InventoryClickEvent event;
    private Button buttonClicked;
    private boolean cancelled;

    /**
     * Instantiates a new Button click event.
     *
     * @param event         the event
     * @param buttonClicked the button clicked
     */
    public ButtonClickEvent (InventoryClickEvent event, Button buttonClicked) {
        this.event = event;
        this.buttonClicked = buttonClicked;
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
     * Gets inventory click event.
     *
     * @return the inventory click event
     */
    public InventoryClickEvent getInventoryClickEvent() {
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
     * Gets button clicked.
     *
     * @return the button clicked
     */
    public Button getButtonClicked() {
        return this.buttonClicked;
    }
}
