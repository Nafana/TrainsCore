package net.nafana.TrainsCore.gui.buttons.types;

import net.nafana.TrainsCore.data.PlayerPermission;
import net.nafana.TrainsCore.gui.buttons.IButtonAction;
import org.bukkit.inventory.ItemStack;

/**
 * The type Economy button.
 *
 * @author Created by Nafana on 2018-07-11
 */
public class EconomyButton extends PermissionButton {

    private float cost;
    private ItemStack item;

    /**
     * Instantiates a new Economy button.
     *
     * @param buttonModel     the button model
     * @param action          the action
     * @param inputPermission the input permission
     */
    public EconomyButton(ItemStack buttonModel, IButtonAction action, PlayerPermission inputPermission) {
        super(buttonModel, action, inputPermission);
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public float getCost() {
        return cost;
    }

    /**
     * Sets cost.
     *
     * @param cost the cost
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * Gets item.
     *
     * @return the item
     */
    public ItemStack getItem() {
        return item;
    }

    /**
     * Sets item.
     *
     * @param item the item
     */
    public void setItem(ItemStack item) {
        this.item = item;
    }
}
