package com.collinriggs.electricmobs.blocks;

import com.collinriggs.electricmobs.ElectricMobs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//Created by Bread10 at 15:50 on 22/04/2017
public abstract class BaseBlock extends Block {

    public BaseBlock(Material material) {
        super(material);
        this.setCreativeTab(ElectricMobs.TAB);
    }

    public void register() {
        register(this);
    }

    protected static void register(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block), block.getRegistryName());
    }

    @SideOnly(value = Side.CLIENT)
    public void registerRender() {
        registerRender(this, 0);
    }

    protected static void registerRender(Block block, int meta) {
        if (block.getRegistryName() != null)
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

}