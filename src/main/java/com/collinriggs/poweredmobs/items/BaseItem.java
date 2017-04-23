package com.collinriggs.poweredmobs.items;

import com.collinriggs.poweredmobs.PoweredMobs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//Created by Bread10 at 18:47 on 22/04/2017
public abstract class BaseItem extends Item {

    protected BaseItem() {
        super();
        this.setCreativeTab(PoweredMobs.TAB);
    }

    protected void register() {
        register(this);
    }

    protected static void register(Item item) {
        GameRegistry.register(item);
    }

    @SideOnly(value = Side.CLIENT)
    protected void registerRender() {
        registerRender(this, 0);
    }

    @SideOnly(value = Side.CLIENT)
    protected static void registerRender(Item item, int meta) {
        if (item.getRegistryName() != null)
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

}
