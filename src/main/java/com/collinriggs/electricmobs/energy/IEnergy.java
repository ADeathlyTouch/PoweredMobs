package com.collinriggs.electricmobs.energy;

import net.minecraft.util.EnumFacing;

//Created by Bread10 at 14:02 on 22/04/2017
public interface IEnergy {

    /**
     * @param maxPowerToInsert Maximum power to insert.
     * @param simulate Whether or not to actually insert power.
     * @return Power inserted.
     */
    int insert(int maxPowerToInsert, boolean simulate);

    /**
     * @param maxPowerToExtract Maxmimum power to extract.
     * @param simulate Whether or not to actually extract power.
     * @return Power extracted.
     */
    int extract(int maxPowerToExtract, boolean simulate);

    /**
     * @return Power stored.
     */
    int getStoredPower();

    /**
     * @return Maximum capacity of power storage.
     */
    int getMaxCapacity();

    /**
     * @param facing Side of block.
     * @return Whether or not power can be inserted.
     */
    boolean canInsertPower(EnumFacing facing);

    /**
     * @param facing Side of block.
     * @return Whether or not power can be extracted.
     */
    boolean canExtractPower(EnumFacing facing);

    /**
     * Used for connecting cables.
     * @param facing Side of block.
     * @return If power can be transfered on this side.
     */
    default boolean canPowerTransfer(EnumFacing facing) {
        return canInsertPower(facing) || canExtractPower(facing);
    }

}