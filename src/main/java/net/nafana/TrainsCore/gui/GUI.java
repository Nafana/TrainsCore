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
 * The GUI object which builds the custom inventory. The GUI object has the concept of items, and buttons.
 * Buttons are items which do a certain action when clicked, items just exist to show information to the player.
 * @author Created by Nafana on 2018-07-07.
 */
public class GUI {

    /**
     * The Inventory object that is displayed in game.
     */
    private Inventory displayInventory;
    /**
     * The stored positions of all buttons in the inventory, as well as the Button objects themselves.
     */
    private Map<Integer, Button> inventoryButtons;
    /**
     * The name which will be displayed on top of the GUI
     */
    private String guiName;
    /**
     * The number of rows in the inventory.
     */
    private int inventoryRows;
    /**
     * The permission needed for the Player to use this button.
     */
    private PlayerPermission inventoryPermission;

    /**
     * Initializes the GUI object.
     * @param inventoryRows The number of rows in the inventory. The columns are always kept constant at 9.
     * @param inventoryTitle The name which will be displayed on top of the GUI
     */
    public GUI(int inventoryRows, String inventoryTitle) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9, inventoryTitle);
        this.inventoryButtons = new HashMap<>();
        this.inventoryPermission = null;
        this.guiName = inventoryTitle;
    }

    /**
     * Initializes the GUI object.
     * @param inventoryRows The number of rows in the inventory. The columns are always kept constant at 9.
     * @param inventoryButtons The stored positions of all buttons in the inventory, as well as the Button object themselves.
     * @param inventoryTitle The name which will be displayed on top of the GUI
     */
    public GUI(int inventoryRows, Map<Integer, Button> inventoryButtons, String inventoryTitle) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9, inventoryTitle);
        this.inventoryButtons = inventoryButtons;
        this.inventoryPermission = null;
        this.guiName = inventoryTitle;
    }

    /**
     * Initializes the GUI object.
     * @param inventoryRows The number of rows in the inventory. The columns are always kept constant at 9.
     */
    public GUI(int inventoryRows) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9);
        this.inventoryButtons = new HashMap<>();
        this.guiName = "";
        this.inventoryPermission = null;
    }

    /**
     * Initializes the GUI object.
     * @param inventoryRows The number of rows in the inventory. The columns are always kept constant at 9.
     * @param inventoryButtons The stored positions of all buttons in the inventory, as well as the Button object themselves.
     */
    public GUI(int inventoryRows, Map<Integer, Button> inventoryButtons) {
        displayInventory = Bukkit.createInventory(null, inventoryRows * 9);
        this.inventoryButtons = inventoryButtons;
        this.inventoryPermission = null;
        this.guiName = "";
    }

    /**
     * Initializes the GUI object.
     * @param inventoryRows The number of rows in the inventory. The columns are always kept constant at 9.
     * @param inventoryTitle The name which will be displayed on top of the GUI
     * @param permission The permission needed for the Player to use this button.
     */
    public GUI(int inventoryRows, String inventoryTitle, PlayerPermission permission) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9, inventoryTitle);
        this.inventoryButtons = new HashMap<>();
        this.inventoryPermission = permission;
        this.guiName = inventoryTitle;
    }

    /**
     * Initializes the GUI object.
     * @param inventoryRows The number of rows in the inventory. The columns are always kept constant at 9.
     * @param inventoryButtons The stored positions of all buttons in the inventory, as well as the Button object themselves.
     * @param inventoryTitle The name which will be displayed on top of the GUI
     * @param permission The permission needed for the Player to use this button.
     */
    public GUI(int inventoryRows, Map<Integer, Button> inventoryButtons, String inventoryTitle, PlayerPermission permission) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9, inventoryTitle);
        this.inventoryButtons = inventoryButtons;
        this.inventoryPermission = permission;
        this.guiName = inventoryTitle;
    }

    /**
     * Initializes the GUI object.
     * @param inventoryRows The number of rows in the inventory. The columns are always kept constant at 9.
     * @param permission The permission needed for the Player to use this button.
     */
    public GUI(int inventoryRows, PlayerPermission permission) {
        this.inventoryRows = inventoryRows;
        this.displayInventory = Bukkit.createInventory(null, inventoryRows * 9);
        this.inventoryButtons = new HashMap<>();
        this.guiName = "";
        this.inventoryPermission = permission;
    }

    /**
     * Initializes the GUI object.
     * @param inventoryRows The number of rows in the inventory. The columns are always kept constant at 9.
     * @param inventoryButtons The stored positions of all buttons in the inventory, as well as the Button object themselves
     * @param permission The permission needed for the Player to use this button.
     */
    public GUI(int inventoryRows, Map<Integer, Button> inventoryButtons, PlayerPermission permission) {
        displayInventory = Bukkit.createInventory(null, inventoryRows * 9);
        this.inventoryButtons = inventoryButtons;
        this.inventoryPermission = permission;
        this.guiName = "";
    }

    /**
     * Removes an item no matter what item it is. If the position contains a button,
     * it will be removed from the inventory buttons map
     * @param inventoryPositionIndex The position index of the slot in the inventory.
     */
    public void removeItemAtIndex(int inventoryPositionIndex) {
        // First check if the item is indeed a button, if it is remove it
        if (this.inventoryButtons.containsKey(inventoryPositionIndex))
            this.inventoryButtons.remove(inventoryPositionIndex);
        displayInventory.setItem(inventoryPositionIndex, new ItemStack(Material.AIR));
    }

    /**
     * Removes an item no matter what item it is. If the position contains a button,
     * it will be removed from the inventory buttons map
     * @param row The row in the Inventory for the slot.
     * @param column The column in the Inventory for the slot.
     */
    public void removeItemAtPosition(int row, int column) {
        int index = getInventoryIndex(row, column);
        if (this.inventoryButtons.containsKey(index))
            this.inventoryButtons.remove(index);
        this.displayInventory.setItem(index, new ItemStack(Material.AIR));
    }

    /**
     * These two methods specifically remove a Button from the inventory and map. No other items will be removed
     * @param row The row in the Inventory for the slot.
     * @param column The column in the Inventory for the slot.
     */
    public void removeButtonAtPosition(int row, int column) {
        int index = getInventoryIndex(row, column);
        if (this.inventoryButtons.containsKey(index)) {
            this.inventoryButtons.remove(index);
            this.displayInventory.setItem(index, new ItemStack(Material.AIR));
        }
    }

    /**
     * These two methods specifically remove a Button from the inventory and map. No other items will be removed
     * @param inventoryPositionIndex The position index of the slot in the inventory.
     */
    public void removeButtonAtIndex(int inventoryPositionIndex) {
        if (this.inventoryButtons.containsKey(inventoryPositionIndex)) {
            this.inventoryButtons.remove(inventoryPositionIndex);
            this.displayInventory.setItem(inventoryPositionIndex, new ItemStack(Material.AIR));
        }
    }

    /**
     * Sets the item at a certain position in the Inventory.
     * @param tileModel The material for the ItemStack
     * @param quantity The quantity of the Item that will be present.
     * @param inventoryPositionIndex The position index of the slot in the inventory.
     */
    public void setItemAtIndex(Material tileModel, int quantity, int inventoryPositionIndex) {
        this.displayInventory.setItem(inventoryPositionIndex, new ItemStack(tileModel, quantity));
    }

    /**
     * Sets the item at a certain position in the Inventory.
     * @param itemStack The ItemStack for the item that will be displayed in the inventory.
     * @param inventoryPositionIndex The position index of the slot in the inventory.
     */
    public void setItemAtIndex(ItemStack itemStack, int inventoryPositionIndex) {
        this.displayInventory.setItem(inventoryPositionIndex, itemStack);
    }

    /**
     * Sets the item at a certain position in the Inventory.
     * @param button The Button object that will be stored in the inventory.
     * @param inventoryPositionIndex The position index of the slot in the inventory.
     */
    public void setItemAtIndex(Button button, int inventoryPositionIndex) {
        this.inventoryButtons.put(inventoryPositionIndex, button);
        this.displayInventory.setItem(inventoryPositionIndex, button.getButtonModel());
    }

    /**
     * Sets the item at a certain position in the Inventory.
     * @param tileModel The material for the ItemStack
     * @param quantity The quantity of the Item that will be present.
     * @param row The row position of the slot in the Inventory.
     * @param column The column position of the slot in the Inventory.
     */
    public void setItemAtPosition(Material tileModel, int quantity, int row, int column) {
        int index = getInventoryIndex(row, column);
        this.displayInventory.setItem(index, new ItemStack(tileModel, quantity));
    }

    /**
     * Sets the item at a certain position in the Inventory.
     * @param itemStack The ItemStack for the item that will be displayed in the inventory.
     * @param row The row position of the slot in the Inventory.
     * @param column The column position of the slot in the Inventory.
     */
    public void setItemAtPosition(ItemStack itemStack, int row, int column) {
        int index = getInventoryIndex(row, column);
        this.displayInventory.setItem(index, itemStack);
    }

    /**
     * Sets the item at a certain position in the Inventory.
     * @param button The Button object that will be stored in the inventory.
     * @param row The row position of the slot in the Inventory.
     * @param column The column position of the slot in the Inventory.
     */
    public void setItemAtPosition(Button button, int row, int column) {
        int index = getInventoryIndex(row, column);
        this.inventoryButtons.put(index, button);
        this.displayInventory.setItem(index, button.getButtonModel());
    }

    /**
     * Fills the inventory with a certain item over the rows.
     * @param itemStack The ItemStack for the item that will be displayed in the inventory.
     * @param initialPosition The start index for the slot at which to start filling the rectangle.
     * @param finalPosition The end index for the slot at which to stop filling the rectangle.
     * @deprecated No longer supported. Use {@link #fillRect(ItemStack, int, int)}
     */
    @Deprecated
    public void fillAlongRow(ItemStack itemStack, int initialPosition, int finalPosition) {
        if (!isCorrectBounds(initialPosition, finalPosition)) {return;}
        for (int i = initialPosition; i <= finalPosition; i++) {
            this.displayInventory.setItem(i, itemStack);
        }
    }

    /**
     * Fills the inventory with a certain item over the rows.
     * @param material The Material for the item that will be displayed in the inventory.
     * @param initialPosition The start index for the slot at which to start filling the rectangle.
     * @param finalPosition The end index for the slot at which to stop filling the rectangle.
     * @deprecated No longer supported. Use {@link #fillRect(ItemStack, int, int)}
     */
    @Deprecated
    public void fillAlongRow(Material material, int quantity ,int initialPosition, int finalPosition) {
        if (!isCorrectBounds(initialPosition, finalPosition)) {return;}
        ItemStack stack = new ItemStack(material, quantity);
        for (int i = initialPosition; i <= finalPosition; i++) {
            this.displayInventory.setItem(i, stack);
        }
    }

    /**
     * Fills the inventory with a certain item over the columns.
     * @param itemStack The ItemStack for the item that will be displayed in the inventory.
     * @param initialPosition The start index for the slot at which to start filling the rectangle.
     * @param finalPosition The end index for the slot at which to stop filling the rectangle.
     * @deprecated No longer supported. Use {@link #fillRect(ItemStack, int, int)}
     */
    @Deprecated
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

    /**
     * Fills the inventory with a certain item over the columns.
     * @param material The Material for the item that will be displayed in the inventory.
     * @param initialPosition The start index for the slot at which to start filling the rectangle.
     * @param finalPosition The end index for the slot at which to stop filling the rectangle.
     * @deprecated No longer supported. Use {@link #fillRect(ItemStack, int, int)}
     */
    @Deprecated
    public void fillAlongColumn(Material material, int quantity ,int initialPosition, int finalPosition) {
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

    /**
     * Fills the inventory with a certain item by filling in a rectangle of space in the Inventory.
     * @param itemStack The ItemStack for the item that will be displayed in the inventory.
     * @param initialPosition The start index for the slot at which to start filling the rectangle.
     * @param finalPosition The end index for the slot at which to stop filling the rectangle.
     */
    public void fillRect(ItemStack itemStack, int initialPosition, int finalPosition) {
        if (!isCorrectBounds(initialPosition, finalPosition)) {return;}
        Vector2D initialPositionVector = getInventoryPosition(initialPosition);
        Vector2D finalPositionVector = getInventoryPosition(initialPosition);
        for (int i = initialPositionVector.getX(); i < finalPositionVector.getX(); i++) {
            for (int j = initialPositionVector.getY(); j < finalPositionVector.getY(); j++) {
                this.displayInventory.setItem(getInventoryIndex(i, j), itemStack);
            }
        }
    }

    /**
     * Fills the inventory with a certain item by filling in a rectangle of space in the Inventory.
     * @param material The Material for the item that will be displayed in the inventory.
     * @param initialPosition The start index for the slot at which to start filling the rectangle.
     * @param finalPosition The end index for the slot at which to stop filling the rectangle.
     */
    public void fillRect(Material material, int quantity ,int initialPosition, int finalPosition) {
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


    /**
     * Gets the inventory index from the matrix like row and column vector.
     * @param row The row of the slot in the inventory.
     * @param column The column of the slot in the inventory.
     * @return The integer value for the index of the slot in the inventory.
     */
    public int getInventoryIndex(int row, int column) {
        if (row > this.inventoryRows || column > 9) {
            return -1;
        } else {
            return (row - 1) * 9 + (column - 1);
        }
    }

    /**
     * Gets the inventory position as a Vector
     * @param inventoryPositionIndex The index in the Inventory for the slot.
     * @return The vector position of the location of the slot in rows and columns.
     */
    public Vector2D getInventoryPosition(int inventoryPositionIndex) {
        int row = Math.floorDiv(inventoryPositionIndex, 9);
        int column = inventoryPositionIndex % 9;
        return new Vector2D(row, column);
    }

    /**
     * Shows the player the inventory, only if the player is allowed to do so.
     * @param player The player to send a GUI.
     */
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

    /**
     * Handles the InventoryClickEvent in the inventory.
     * @param event The InventoryClickEvent that was fired in the Inventory.
     */
    public void handleClick(InventoryClickEvent event) {
        if (this.inventoryButtons.containsKey(event.getRawSlot())) {
            Bukkit.getServer().getPluginManager().callEvent(new ButtonClickEvent(
                    event, this.inventoryButtons.get(event.getRawSlot())));
        }
    }

    /**
     * Checks if the inventory slot index is within the bounds of this inventory.
     * @param position The index for the slot in the inventory.
     * @return True if the position is within bounds, false if it's not.
     */
    protected boolean isWithinBounds(int position) {
        return !(position < 0 || position > (this.inventoryRows * 9) - 1);
    }

    /**
     * Checks if a rectangle can be drawn successfully from the initial to the final vertex.
     * @param initialPosition The initial inventory slot index.
     * @param finalPosition The final inventory slot index.
     * @return True if the rectangle can be drawn, false if it cannot.
     */
    protected boolean isCorrectBounds(int initialPosition, int finalPosition) {
        return isWithinBounds(initialPosition) && isWithinBounds(finalPosition) && initialPosition <= finalPosition;
    }

    /**
     * Gets the amount of rows in the inventory.
     * @return The Integer value for the number of rows in the Inventory.
     */
    public int getInventoryRows() { return inventoryRows; }

    /**
     * Gets the Bukkit Inventory that will be shown to the player.
     * @return The Bukkit Inventory that was built.
     */
    public Inventory getDisplayInventory() {
        return displayInventory;
    }

    /**
     * Gets the map of all Button indexes and Button objects as a Map.
     * @return The Map of Integers represeting the slot positions, and the Button objects.
     */
    public Map<Integer, Button> getInventoryButtons() {
        return inventoryButtons;
    }

    /**
     * Gets the name of the GUI
     * @return The String of the Inventory Title, may have colors.
     */
    public String getGuiName() {
        return guiName;
    }

    /**
     * Sets the name of the Bukkit Inventory title.
     * @param guiName The String name of the inventory, can use colors.
     */
    public void setGuiName(String guiName) {
        this.guiName = guiName;
    }

}
