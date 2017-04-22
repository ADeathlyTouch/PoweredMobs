package com.collinriggs.poweredmobs.energy;

import com.collinriggs.poweredmobs.blocks.ISyncable;
import com.collinriggs.poweredmobs.util.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

//Created by Bread10 at 14:08 on 22/04/2017
public class TileEnergy extends TileEntity implements IEnergy, ISyncable {

    protected int power;
    protected final int CAPACITY;
    protected final int MAX_INPUT;
    protected final int MAX_OUTPUT;

    public TileEnergy(int capacity) {
        this(capacity, 1000);
    }

    public TileEnergy(int capacity, int transferRate) {
        this(capacity, transferRate, transferRate);
    }

    public TileEnergy(int capacity, int maxIn, int maxOut) {
        this.CAPACITY = capacity;
        this.MAX_INPUT = maxIn;
        this.MAX_OUTPUT = maxOut;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setInteger("power", power);

        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        this.power = compound.getInteger("power");
    }

    @Override
    public int insert(int maxPowerToInsert, boolean simulate) {
        int powerCanInsert = MathHelper.max(maxPowerToInsert, MAX_INPUT);
        int powerToInsert = MathHelper.max(powerCanInsert, CAPACITY - power);
        if (!simulate)
            power += powerToInsert;
        this.sync();
        return powerToInsert;
    }

    @Override
    public int extract(int maxPowerToExtract, boolean simulate) {
        int powerCanExtract = MathHelper.min(maxPowerToExtract, MAX_OUTPUT);
        int powerToExtract = MathHelper.min(powerCanExtract, power);
        if (!simulate)
            power -= powerToExtract;
        this.sync();
        return powerToExtract;
    }

    @Override
    public int getStoredPower() {
        return power;
    }

    @Override
    public int getMaxCapacity() {
        return CAPACITY;
    }

    @Override
    public boolean canInsertPower(EnumFacing facing) {
        return MAX_INPUT > 0;
    }

    @Override
    public boolean canExtractPower(EnumFacing facing) {
        return MAX_OUTPUT > 0;
    }

    public void setPower(int power) {
        this.power = power;
        this.power = MathHelper.clamp(this.power, 0, CAPACITY);
        this.sync();
    }

}