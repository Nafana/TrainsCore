package net.nafana.TrainsCore.gui.buttons.types;

import net.nafana.TrainsCore.data.PlayerPermission;
import net.nafana.TrainsCore.gui.buttons.Button;
import net.nafana.TrainsCore.gui.buttons.IButtonAction;
import org.bukkit.inventory.ItemStack;

/**
 * Button instance that requires a permission by the player to run the IButtonAction
 *
 * @author Created by Nafana on 2017-07-11
 */
public class PermissionButton extends Button {

    /**
     * The required player permission for the action to run
     */
    private static PlayerPermission permission;

    /**
     * @param buttonModel     The button material type, or display
     * @param action          Function that happens when the button is clicked
     * @param inputPermission Permission the player will be required to have to click the button
     */
    public PermissionButton(ItemStack buttonModel, IButtonAction action, PlayerPermission inputPermission) {
        super(buttonModel, action);
        permission = inputPermission;
    }

    /**
     * @return
     */
    public PlayerPermission getPlayerPermission() {
        return permission;
    }

}
