package com.collinriggs.electricmobs.blocks;

import com.collinriggs.electricmobs.blocks.generator.BlockGenerator;
import com.collinriggs.electricmobs.blocks.generator.TileGenerator;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

//Created by Bread10 at 20:04 on 21/04/2017
public final class ModBlocks {
    private static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block GENERATOR;

    static {
        BLOCKS.add(GENERATOR = new BlockGenerator());
    }

    public static void register() {
        for (Block block : BLOCKS) {
            if (block instanceof BaseBlock) {
                ((BaseBlock) block).register();
            }
        }

        GameRegistry.registerTileEntity(TileGenerator.class, "generator");
    }

    @SideOnly(value = Side.CLIENT)
    public static void registerRenders() {
        for (Block block : BLOCKS) {
            if (block instanceof BaseBlock) {
                ((BaseBlock) block).registerRender();
            }
        }
    }

}