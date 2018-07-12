package net.nafana.TrainsCore.gui.buttons;

import org.bukkit.inventory.ItemStack;

/**
 * The type Button.
 *
 * @author Created by Nafana on 2018-07-11
 */
public abstract class Button {

    private ItemStack buttonModel;
    private IButtonAction buttonAction;

    /**
     * Instantiates a new Button.
     *
     * @param buttonModel the button model
     * @param action      the action
     */
    public Button(ItemStack buttonModel, IButtonAction action) {
        this.buttonModel = buttonModel;
        this.buttonAction = action;
    }

    /**
     * Gets button model.
     *
     * @return the button model
     */
// What item represents the button
    public ItemStack getButtonModel() {
        return this.buttonModel;
    }

    /**
     * Button action button action.
     *
     * @return the button action
     */
// Get the action of the button when clicked
    public IButtonAction buttonAction() {
        return this.buttonAction;
    }
}
