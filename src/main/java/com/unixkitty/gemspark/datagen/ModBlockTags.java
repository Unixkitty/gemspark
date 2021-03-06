package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

@SuppressWarnings("ConstantConditions")
public class ModBlockTags extends BlockTagsProvider
{
    public ModBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, Gemspark.MODID, existingFileHelper);
    }

    @Override
    protected void registerTags()
    {
        getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTags(
                ModTags.Blocks.TANZANITE_BLOCK,
                ModTags.Blocks.TOPAZ_BLOCK,
                ModTags.Blocks.SAPPHIRE_BLOCK,
                ModTags.Blocks.PINK_SAPPHIRE_BLOCK,
                ModTags.Blocks.RUBY_BLOCK
        );
        getOrCreateBuilder(ModTags.Blocks.TANZANITE_BLOCK).add(ModBlocks.TANZANITE_BLOCK.get());
        getOrCreateBuilder(ModTags.Blocks.TOPAZ_BLOCK).add(ModBlocks.TOPAZ_BLOCK.get());
        getOrCreateBuilder(ModTags.Blocks.SAPPHIRE_BLOCK).add(ModBlocks.SAPPHIRE_BLOCK.get());
        getOrCreateBuilder(ModTags.Blocks.PINK_SAPPHIRE_BLOCK).add(ModBlocks.PINK_SAPPHIRE_BLOCK.get());
        getOrCreateBuilder(ModTags.Blocks.RUBY_BLOCK).add(ModBlocks.RUBY_BLOCK.get());

        getOrCreateBuilder(Tags.Blocks.ORES).addTags(
                ModTags.Blocks.TANZANITE_ORE,
                ModTags.Blocks.TOPAZ_ORE,
                ModTags.Blocks.SAPPHIRE_ORE,
                ModTags.Blocks.PINK_SAPPHIRE_ORE,
                ModTags.Blocks.RUBY_ORE
        );
        getOrCreateBuilder(ModTags.Blocks.TANZANITE_ORE).add(ModBlocks.TANZANITE_ORE.get());
        getOrCreateBuilder(ModTags.Blocks.TOPAZ_ORE).add(ModBlocks.TOPAZ_ORE.get());
        getOrCreateBuilder(ModTags.Blocks.SAPPHIRE_ORE).add(ModBlocks.SAPPHIRE_ORE.get());
        getOrCreateBuilder(ModTags.Blocks.PINK_SAPPHIRE_ORE).add(ModBlocks.PINK_SAPPHIRE_ORE.get());
        getOrCreateBuilder(ModTags.Blocks.RUBY_ORE).add(ModBlocks.RUBY_ORE.get());

        getOrCreateBuilder(BlockTags.CAMPFIRES).add(ModBlocks.BRAZIER.get(), ModBlocks.SOUL_BRAZIER.get());
    }

    @Override
    public String getName()
    {
        return Gemspark.MODNAME + " " + this.getClass().getSimpleName();
    }
}
