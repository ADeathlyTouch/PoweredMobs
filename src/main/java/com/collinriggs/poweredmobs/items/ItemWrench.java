package com.collinriggs.poweredmobs.items;

import com.collinriggs.poweredmobs.blocks.machine.Wrenchable;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//Created by Bread10 at 18:56 on 22/04/2017
public class ItemWrench extends BaseItem {

    public ItemWrench() {
        super();
        this.setRegistryName("wrench");
        this.setUnlocalizedName("wrench");
        this.setMaxStackSize(1);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote && player.isSneaking()) {
            Block block = worldIn.getBlockState(pos).getBlock();
            if (block.getClass().isAnnotationPresent(Wrenchable.class)) {
                worldIn.destroyBlock(pos, !(player.isCreative() || player.isSpectator()));
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.FAIL;
    }
}