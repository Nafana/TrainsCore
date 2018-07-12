package net.nafana.TrainsCore.data;

import org.bukkit.entity.Player;

/**
 * The enum Player permission.
 *
 * @author Created by GrimlyTwisted on 2018-07-11
 */
public enum PlayerPermission {

    /**
     * Buy train player permission.
     */
    BUY_TRAIN("trainscore.train.buy"),

    /**
     * Sell train player permission.
     */
    SELL_TRAIN("trainscore.train.sell"),

    /**
     * Buy item player permission.
     */
    BUY_ITEM("trainscore.item.buy"),

    /**
     * Sell item player permission.
     */
    SELL_ITEM("trainscore.item.sell");

    private final String permission;

    PlayerPermission(String permission) {
        this.permission = permission;
    }

    /**
     * Gets permission.
     *
     * @return the permission
     */
    public String getPermission() {
        return this.permission;
    }

    /**
     * Player has permission boolean.
     *
     * @param player the player
     * @return the boolean
     */
    public boolean playerHasPermission(Player player) {
        return player.hasPermission(this.getPermission());
    }
}
