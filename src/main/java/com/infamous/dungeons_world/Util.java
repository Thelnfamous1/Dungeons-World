package com.infamous.dungeons_world;

import net.minecraft.util.ResourceLocation;

import static com.infamous.dungeons_world.DungeonsWorld.MODID;

public class Util {
    public static ResourceLocation ModLoc(String id){
        return new ResourceLocation(MODID,  id);
    }
}
