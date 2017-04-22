package com.collinriggs.poweredmobs;

import com.collinriggs.poweredmobs.blocks.ModBlocks;
import com.collinriggs.poweredmobs.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

//Created by Bread10 at 18:16 on 21/04/2017
@Mod(modid = PoweredMobs.MODID, name = "Powered Mobs", version = "1.0")
public class PoweredMobs {
    public static final String MODID = "poweredmobs";

    @Instance
    public static PoweredMobs instance;

    @SidedProxy(clientSide = "com.collinriggs.poweredmobs.proxy.ClientProxy", serverSide = "com.collinriggs.poweredmobs.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static final CreativeTabs TAB = new CreativeTabs(MODID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.GENERATOR);
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

}