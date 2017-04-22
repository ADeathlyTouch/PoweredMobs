package com.collinriggs.electricmobs.proxy;

import com.collinriggs.electricmobs.blocks.ModBlocks;

//Created by Bread10 at 15:43 on 22/04/2017
public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        super.init();

        ModBlocks.registerRenders();
    }
}