package net.nafana.TrainsCore.gui.buttons.types;

import net.nafana.TrainsCore.data.PlayerPermission;
import net.nafana.TrainsCore.gui.buttons.Button;
import net.nafana.TrainsCore.gui.buttons.IButtonAction;
import org.bukkit.inventory.ItemStack;

public class PermissionButton extends Button {

    private static PlayerPermission permission;

    public PermissionButton(ItemStack buttonModel, IButtonAction action, PlayerPermission inputPermission) {
        super(buttonModel, action);
        permission = inputPermission;
    }

    public PlayerPermission getPlayerPermission(){
        return permission;
    }

}
