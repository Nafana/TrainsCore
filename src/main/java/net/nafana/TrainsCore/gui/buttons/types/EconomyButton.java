package net.nafana.TrainsCore.gui.buttons.types;

import net.nafana.TrainsCore.data.PlayerPermission;
import net.nafana.TrainsCore.gui.buttons.IButtonAction;
import org.bukkit.inventory.ItemStack;

public class EconomyButton extends PermissionButton {

    private float cost;
    private ItemStack item;

    public EconomyButton(ItemStack buttonModel, IButtonAction action, PlayerPermission inputPermission) {
        super(buttonModel, action, inputPermission);
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }
}
