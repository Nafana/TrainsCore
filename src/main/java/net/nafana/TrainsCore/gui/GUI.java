package net.nafana.TrainsCore.gui;

import net.nafana.TrainsCore.data.PlayerPermission;
import net.nafana.TrainsCore.events.ButtonClickEvent;
import net.nafana.TrainsCore.gui.buttons.Button;
import net.nafana.TrainsCore.utils.Vector2D;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nafana on 2018-07-07.
 */
public class GUI {

    private Inventory displayInventory;
    private Map<Integer, Button> inventoryButtons;
    private String guiName;
    private int inventoryRows;
    private PlayerPermission inventoryPermission;

    public GUI(int inventoryRows, String inventoryTitle) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9, inventoryTitle);
        this.inventoryButtons = new HashMap<>();
        this.inventoryPermission = null;
        this.guiName = inventoryTitle;
    }

    public GUI(int inventoryRows, Map<Integer, Button> inventoryButtons, String inventoryTitle) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9, inventoryTitle);
        this.inventoryButtons = inventoryButtons;
        this.inventoryPermission = null;
        this.guiName = inventoryTitle;
    }

    public GUI(int inventoryRows) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9);
        this.inventoryButtons = new HashMap<>();
        this.guiName = "";
        this.inventoryPermission = null;
    }

    public GUI(int inventoryRows, Map<Integer, Button> inventoryButtons) {
        displayInventory = Bukkit.createInventory(null, inventoryRows * 9);
        this.inventoryButtons = inventoryButtons;
        this.inventoryPermission = null;
        this.guiName = "";
    }

    public GUI(int inventoryRows, String inventoryTitle, PlayerPermission permission) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9, inventoryTitle);
        this.inventoryButtons = new HashMap<>();
        this.inventoryPermission = permission;
        this.guiName = inventoryTitle;
    }

    public GUI(int inventoryRows, Map<Integer, Button> inventoryButtons, String inventoryTitle, PlayerPermission permission) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9, inventoryTitle);
        this.inventoryButtons = inventoryButtons;
        this.inventoryPermission = permission;
        this.guiName = inventoryTitle;
    }

    public GUI(int inventoryRows, PlayerPermission permission) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9);
        this.inventoryButtons = new HashMap<>();
        this.guiName = "";
        this.inventoryPermission = permission;
    }

    public GUI(int inventoryRows, Map<Integer, Button> inventoryButtons, PlayerPermission permission) {
        displayInventory = Bukkit.createInventory(null, inventoryRows * 9);
        this.inventoryButtons = inventoryButtons;
        this.inventoryPermission = permission;
        this.guiName = "";
    }

    //** These two methods remove an item no matter what item it is.
    //   If the position contains a button, it will be removed from the inventory buttons map. **//
    public void removeItemAtIndex(int inventoryPositionIndex) {
        // First check if the item is indeed a button, if it is remove it
        if (this.inventoryButtons.containsKey(inventoryPositionIndex))
            this.inventoryButtons.remove(inventoryPositionIndex);
        displayInventory.setItem(inventoryPositionIndex, new ItemStack(Material.AIR));
    }

    public void removeItemAtPosition(int row, int column) {
        int index = getInventoryIndex(row, column);
        if (this.inventoryButtons.containsKey(index))
            this.inventoryButtons.remove(index);
        this.displayInventory.setItem(index, new ItemStack(Material.AIR));
    }

    //** These two methods specifically remove a Button from the inventory and map
    //   No other items will be removed.**//
    public void removeButtonAtPosition(int row, int column) {
        int index = getInventoryIndex(row, column);
        if (this.inventoryButtons.containsKey(index)) {
            this.inventoryButtons.remove(index);
            this.displayInventory.setItem(index, new ItemStack(Material.AIR));
        }
    }

    public void removeButtonAtIndex(int inventoryPositionIndex) {
        if (this.inventoryButtons.containsKey(inventoryPositionIndex)) {
            this.inventoryButtons.remove(inventoryPositionIndex);
            this.displayInventory.setItem(inventoryPositionIndex, new ItemStack(Material.AIR));
        }
    }

    //** These four methods set an item at a given location in the inventory,
    //   note that any item can be simply passed in it's button, material, or itemstack form.**//
    public void setItemAtIndex(Material tileModel, int quantity, int inventoryPositionIndex) {
        this.displayInventory.setItem(inventoryPositionIndex, new ItemStack(tileModel, quantity));
    }

    public void setItemAtIndex(ItemStack itemStack, int inventoryPositionIndex) {
        this.displayInventory.setItem(inventoryPositionIndex, itemStack);
    }

    public void setItemAtIndex(Button button, int position) {
        this.inventoryButtons.put(position, button);
        this.displayInventory.setItem(position, button.getButtonModel());
    }

    public void setItemAtPosition(Material tileModel, int quantity, int row, int column) {
        int index = getInventoryIndex(row, column);
        this.displayInventory.setItem(index, new ItemStack(tileModel, quantity));
    }

    public void setItemAtPosition(ItemStack itemStack, int row, int column) {
        int index = getInventoryIndex(row, column);
        this.displayInventory.setItem(index, itemStack);
    }

    public void setItemAtPosition(Button button, int row, int column) {
        int index = getInventoryIndex(row, column);
        this.inventoryButtons.put(index, button);
        this.displayInventory.setItem(index, button.getButtonModel());
    }

    //** Fills the inventory with a certain item over the rows. **//
    public void fillAlongRow(ItemStack itemStack, int initialPosition, int finalPosition) {
        if (!isCorrectBounds(initialPosition, finalPosition)) {return;}
        for (int i = initialPosition; i <= finalPosition; i++) {
            this.displayInventory.setItem(i, itemStack);
        }
    }

    public void fillAlongRow(Material material, int quantity, int initialPosition, int finalPosition) {
        if (!isCorrectBounds(initialPosition, finalPosition)) {return;}
        ItemStack stack = new ItemStack(material, quantity);
        for (int i = initialPosition; i <= finalPosition; i++) {
            this.displayInventory.setItem(i, stack);
        }
    }

    //** Fills the inventory with a certain item over the columns. **//
    public void fillAlongColumn(ItemStack itemStack, int initialPosition, int finalPosition) {
        if (!isCorrectBounds(initialPosition, finalPosition)) {return;}
        Vector2D initialPositionVector = getInventoryPosition(initialPosition);
        Vector2D finalPositionVector = getInventoryPosition(initialPosition);
        for (int i = initialPositionVector.getX(); i < finalPositionVector.getX(); i++) {
            for (int j = initialPositionVector.getY(); j < finalPositionVector.getY(); j++) {
                this.displayInventory.setItem(getInventoryIndex(i, j), itemStack);
            }
        }
    }

    //** Fills the inventory with a certain item over the columns. **//
    public void fillAlongColumn(Material material, int quantity, int initialPosition, int finalPosition) {
        if (!isCorrectBounds(initialPosition, finalPosition)) {return;}
        ItemStack stack = new ItemStack(material, quantity);
        Vector2D initialPositionVector = getInventoryPosition(initialPosition);
        Vector2D finalPositionVector = getInventoryPosition(initialPosition);
        for (int i = initialPositionVector.getX(); i < finalPositionVector.getX(); i++) {
            for (int j = initialPositionVector.getY(); j < finalPositionVector.getY(); j++) {
                this.displayInventory.setItem(getInventoryIndex(i, j), stack);
            }
        }
    }

    //** Gets the inventory index from the row and column input **/
    public int getInventoryIndex(int row, int column) {
        if (row > this.inventoryRows || column > 9) {
            return -1;
        } else {
            return (row - 1) * 9 + (column - 1);
        }
    }

    //** Gets the inventory position as a Vector **//
    public Vector2D getInventoryPosition(int inventoryPositionIndex) {
        int row = Math.floorDiv(inventoryPositionIndex, 9);
        int column = inventoryPositionIndex % 9;
        return new Vector2D(row, column);
    }

    public void showPlayerInventory(Player player) {
        if (this.inventoryPermission != null) {
            if (this.inventoryPermission.playerHasPermission(player)) {
                player.openInventory(this.displayInventory);
            } else {
                //TODO: Send a message to the player telling them that they cannot open the inventory.
                //Make sure this message gets pulled from the config file!
                if (this.guiName == null || this.guiName.isEmpty()) {
                    player.sendMessage("Could not open the selected inventory. Invalid permission.");
                } else {
                    player.sendMessage("Could not open the " + this.guiName + " inventory. Invalid permission.");
                }
            }
        } else {
            player.openInventory(this.displayInventory);
        }
    }

    //** Handles the click event for this inventory **//
    public void handleClick(InventoryClickEvent event) {
        if (this.inventoryButtons.containsKey(event.getRawSlot())) {
            Bukkit.getServer().getPluginManager().callEvent(new ButtonClickEvent(
                    event, this.inventoryButtons.get(event.getRawSlot())));
        }
    }

    protected boolean isWithinBounds(int position) {
        return !(position < 0 || position > (this.inventoryRows * 9) - 1);
    }

    protected boolean isCorrectBounds(int initialPosition, int finalPosition) {
        return isWithinBounds(initialPosition) && isWithinBounds(finalPosition) && initialPosition <= finalPosition;
    }

    public int getInventoryRows() { return inventoryRows; }

    public Inventory getDisplayInventory() {
        return displayInventory;
    }

    public Map<Integer, Button> getInventoryButtons() {
        return inventoryButtons;
    }

    public String getGuiName() {
        return guiName;
    }

    public void setDisplayInventory(Inventory displayInventory) {
        this.displayInventory = displayInventory;
    }

    public void setInventoryButtons(Map<Integer, Button> inventoryButtons) {
        this.inventoryButtons = inventoryButtons;
    }

    public void setGuiName(String guiName) {
        this.guiName = guiName;
    }

}
