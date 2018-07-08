package net.nafana.TrainsCore.data.gui;

import net.nafana.TrainsCore.data.gui.buttons.Button;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nafana on 2018-07-07.
 */
public abstract class GUI {

    private Inventory displayInventory;
    private Map<Button, Integer> inventoryButtons;
    private String guiName;

    public GUI(int inventoryRows) {
        displayInventory = Bukkit.createInventory(null, inventoryRows * 9);
        this.inventoryButtons = new HashMap<>();
    }

    public GUI(int inventoryRows, Map<Button, Integer> inventoryButtons) {
        displayInventory = Bukkit.createInventory(null, inventoryRows * 9);
        this.inventoryButtons = inventoryButtons;
    }

    public void setButton(Button button, final int row, final int column) {
        int position = (row - 1) * 9 + (column - 1);
    }

    public void setTile(Material tileModel, int quantity) {

    }

    public void removeButton() {}
    public void removeTile() {}

    public Inventory getDisplayInventory() {
        return displayInventory;
    }

    public Map<Button, Integer> getInventoryButtons() {
        return inventoryButtons;
    }

    public String getGuiName() {
        return guiName;
    }

    public void setDisplayInventory(Inventory displayInventory) {
        this.displayInventory = displayInventory;
    }

    public void setInventoryButtons(Map<Button, Integer> inventoryButtons) {
        this.inventoryButtons = inventoryButtons;
    }

    public void setGuiName(String guiName) {
        this.guiName = guiName;
    }

    public void handleClick(InventoryClickEvent event) {}
}
