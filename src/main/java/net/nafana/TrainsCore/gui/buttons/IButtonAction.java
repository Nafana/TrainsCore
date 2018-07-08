package net.nafana.TrainsCore.gui.buttons;

import org.bukkit.event.inventory.InventoryClickEvent;

public interface IButtonAction {

    // Tells the button to do a certain action
    void doAction(InventoryClickEvent event);

}
