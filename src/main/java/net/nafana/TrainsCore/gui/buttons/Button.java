package net.nafana.TrainsCore.gui.buttons;

import org.bukkit.inventory.ItemStack;

public abstract class Button {

    private ItemStack buttonModel;
    private IButtonAction buttonAction;

    public Button (ItemStack buttonModel, IButtonAction action) {
        this.buttonModel = buttonModel;
        this.buttonAction = action;
    }

    public ItemStack getButtonModel () { return this.buttonModel;}

    public IButtonAction buttonAction() {return this.buttonAction; }

}
