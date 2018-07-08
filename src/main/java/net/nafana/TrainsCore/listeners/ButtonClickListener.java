package net.nafana.TrainsCore.listeners;

import net.nafana.TrainsCore.events.ButtonClickEvent;
import net.nafana.TrainsCore.gui.buttons.types.PermissionButton;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ButtonClickListener implements Listener {

    @EventHandler
    public void onButtonClick(ButtonClickEvent e) {
        if (e.getButtonClicked() instanceof PermissionButton) {
            PermissionButton button = (PermissionButton) e.getButtonClicked();
            if (button.getPlayerPermission().playerHasPermission((Player) e.getInventoryClickEvent().getWhoClicked())) {
                button.buttonAction().doAction(e.getInventoryClickEvent());
            } else {
                //TODO: Add custom config error messages with each button
                e.getInventoryClickEvent().getWhoClicked().sendMessage("You cannot press that button!");
            }
        } else {
            e.getButtonClicked().buttonAction().doAction(e.getInventoryClickEvent());
        }
    }

}
