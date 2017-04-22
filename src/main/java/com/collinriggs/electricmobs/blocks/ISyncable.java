package com.collinriggs.electricmobs.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;

//Created by Bread10 at 14:31 on 22/04/2017
public interface ISyncable {

    default void sync() {
        TileEntity tileEntity = (TileEntity) this;
        tileEntity.markDirty();
        IBlockState state = tileEntity.getWorld().getBlockState(tileEntity.getPos());
        tileEntity.getWorld().notifyBlockUpdate(tileEntity.getPos(), state, state, 3);
    }

}
