package net.nafana.TrainsCore.events;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryView;

public class ButtonClickEvent extends InventoryClickEvent {

    public ButtonClickEvent(InventoryView view, InventoryType.SlotType type, int slot, ClickType click, InventoryAction action) {
        super(view, type, slot, click, action);
    }
}
