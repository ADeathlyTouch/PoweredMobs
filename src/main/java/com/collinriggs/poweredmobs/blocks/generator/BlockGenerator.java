package com.collinriggs.poweredmobs.blocks.generator;

import com.collinriggs.poweredmobs.PoweredMobs;
import com.collinriggs.poweredmobs.blocks.BlockRotatable;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

//Created by Bread10 at 09:48 on 22/04/2017
public class BlockGenerator extends BlockRotatable implements ITileEntityProvider {

    public BlockGenerator() {
        super(Material.IRON);
        this.setRegistryName(PoweredMobs.MODID, "generator");
        this.setUnlocalizedName("generator");
        this.setHarvestLevel("pickaxe", 1);
        this.setHardness(1F);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileGenerator();
    }

}