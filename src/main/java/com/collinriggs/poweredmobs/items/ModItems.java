package com.collinriggs.poweredmobs.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

//Created by Bread10 at 18:46 on 22/04/2017
public final class ModItems {
    private static final List<Item> ITEMS = new ArrayList<>();

    public static final Item WRENCH;

    static {
        ITEMS.add(WRENCH = new ItemWrench());
    }

    public static void register() {
        for (Item item : ITEMS) {
            if (item instanceof BaseItem) {
                ((BaseItem) item).register();
            }
        }
    }

    @SideOnly(value = Side.CLIENT)
    public static void registerRenders() {
        for (Item item : ITEMS) {
            if (item instanceof BaseItem) {
                ((BaseItem) item).registerRender();
            }
        }
    }

}
