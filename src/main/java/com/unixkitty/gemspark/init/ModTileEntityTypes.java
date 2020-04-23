package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.tileentity.TileEntityPedestal;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModTileEntityTypes
{
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Gemspark.MODID);

    public static final RegistryObject<TileEntityType<TileEntityPedestal>> PEDESTAL = TILE_ENTITY_TYPES.register("quartz_pedestal", () ->
            TileEntityType.Builder.create(TileEntityPedestal::new, ModBlocks.quartz_pedestal.get())
                    .build(null)
    );
}