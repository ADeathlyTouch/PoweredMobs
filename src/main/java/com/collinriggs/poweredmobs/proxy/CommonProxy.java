package com.collinriggs.poweredmobs.proxy;

import com.collinriggs.poweredmobs.blocks.ModBlocks;
import com.collinriggs.poweredmobs.items.ModItems;

//Created by Bread10 at 15:41 on 22/04/2017
public class CommonProxy {

    public void preInit() {
        ModBlocks.register();
        ModItems.register();
    }

    public void init() {

    }

}