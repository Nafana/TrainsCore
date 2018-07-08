package net.nafana.TrainsCore.data;

import org.bukkit.entity.Player;

public enum PlayerPermission {

    BUY_TRAIN("trainscore.train.buy"),
    SELL_TRAIN("trainscore.train.sell"),
    BUY_ITEM("trainscore.item.buy"),
    SELL_ITEM("trainscore.item.sell");

    private final String permission;

    PlayerPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }

    public boolean playerHasPermission(Player player) {
        return player.hasPermission(this.getPermission());
    }
}
