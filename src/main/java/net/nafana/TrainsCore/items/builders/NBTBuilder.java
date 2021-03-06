package net.nafana.TrainsCore.items.builders;

import net.minecraft.server.v1_12_R1.NBTBase;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import net.minecraft.server.v1_12_R1.NBTTagList;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

/**
 * Implemented by Nafana on 2018-07-05.
 * Created by TreeMC - https://www.mc-market.org/members/62796/
 */
public class NBTBuilder {

    public NBTBuilder () {}

    public ItemStack setValue(ItemStack item, String key, NBTBase value) {
        net.minecraft.server.v1_12_R1.ItemStack stack;
        if (!item.hasItemMeta()) {
            this.throwArgException();
        }
        NBTTagCompound tag = (stack = CraftItemStack.asNMSCopy(item)).hasTag() ? stack.getTag() : new NBTTagCompound();
        tag.set(key, value);
        stack.setTag(tag);
        return CraftItemStack.asBukkitCopy(stack);
    }

    public NBTBase getValue(ItemStack item, String key) {
        NBTTagCompound tag;
        net.minecraft.server.v1_12_R1.ItemStack stack;
        if (!item.hasItemMeta()) {
            this.throwArgException();
        }
        return (tag = (stack = CraftItemStack.asNMSCopy(item)).getTag()) != null ? tag.get(key) : null;
    }

    public NBTTagList getListValue(ItemStack item, String key) {
        NBTTagCompound itemTag;
        net.minecraft.server.v1_12_R1.ItemStack stack;
        if (!item.hasItemMeta()) {
            this.throwArgException();
        }
        return (itemTag = (stack = CraftItemStack.asNMSCopy(item)).getTag()) != null ? itemTag.getList(key, 0) : null;
    }

    public ItemStack setValue(ItemStack item, String key, Map<String, NBTBase> data) {
        net.minecraft.server.v1_12_R1.ItemStack stack;
        if (!item.hasItemMeta()) {
            this.throwArgException();
        }
        NBTTagCompound itemTag = (stack = CraftItemStack.asNMSCopy(item)).hasTag() ? stack.getTag() : new NBTTagCompound();
        NBTTagCompound tag = new NBTTagCompound();
        NBTTagList list = new NBTTagList();
        data.entrySet().forEach(set -> tag.set(set.getKey(), set.getValue())
        );
        list.add(tag);
        itemTag.set(key, list);
        stack.setTag(itemTag);
        return CraftItemStack.asBukkitCopy(stack);
    }

    private void throwArgException() {
        throw new IllegalArgumentException("ItemStacks must have an item-meta to use nbt tags");
    }

}
