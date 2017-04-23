package com.collinriggs.poweredmobs.proxy;

import com.collinriggs.poweredmobs.blocks.ModBlocks;
import com.collinriggs.poweredmobs.items.ModItems;

//Created by Bread10 at 15:43 on 22/04/2017
public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        super.init();

        ModBlocks.registerRenders();
        ModItems.registerRenders();
    }
}