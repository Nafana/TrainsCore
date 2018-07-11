package net.nafana.TrainsCore.gui.buttons;

import org.bukkit.inventory.ItemStack;

public abstract class Button {

    private ItemStack buttonModel;
    private IButtonAction buttonAction;

    public Button (ItemStack buttonModel, IButtonAction action) {
        this.buttonModel = buttonModel;
        this.buttonAction = action;
    }

    // What item represents the button
    public ItemStack getButtonModel () {
        return this.buttonModel;
    }

    // Get the action of the button when clicked
    public IButtonAction buttonAction() {
        return this.buttonAction;
    }
}
