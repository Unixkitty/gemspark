package com.unixkitty.gemspark.datagen.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unixkitty.gemspark.Gemspark;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.MatchTool;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import net.minecraft.world.storage.loot.functions.ApplyBonus;
import net.minecraft.world.storage.loot.functions.CopyNbt;
import net.minecraft.world.storage.loot.functions.ExplosionDecay;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.registries.ForgeRegistries;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

//Thanks Botania/src/main/java/vazkii/botania/data/BlockLootProvider.java
public abstract class ModBlockLootProvider implements IDataProvider
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final DataGenerator generator;
    private final Map<Block, Function<Block, LootTable.Builder>> functionTable = new HashMap<>();

    public ModBlockLootProvider(DataGenerator generator)
    {
        this.generator = generator;

        addTables();
    }

    protected abstract void addTables();

    protected void registerLoot(Block block, Function<Block, LootTable.Builder> table)
    {
        functionTable.put(block, table);
    }

    @Override
    public final void act(DirectoryCache cache) throws IOException
    {
        Map<ResourceLocation, LootTable.Builder> tables = new HashMap<>();

        for (Block b : ForgeRegistries.BLOCKS)
        {
            if (!Gemspark.MODID.equals(Objects.requireNonNull(b.getRegistryName()).getNamespace()))
            {
                continue;
            }
            Function<Block, LootTable.Builder> func = functionTable.getOrDefault(b, ModBlockLootProvider::genRegular);
            tables.put(b.getRegistryName(), func.apply(b));
        }

        for (Map.Entry<ResourceLocation, LootTable.Builder> e : tables.entrySet())
        {
            Path path = getPath(generator.getOutputFolder(), e.getKey());
            IDataProvider.save(GSON, cache, LootTableManager.toJson(e.getValue().setParameterSet(LootParameterSets.BLOCK).build()), path);
        }
    }

    private static Path getPath(Path root, ResourceLocation resourceLocation)
    {
        return root.resolve("data/" + resourceLocation.getNamespace() + "/loot_tables/blocks/" + resourceLocation.getPath() + ".json");
    }

    protected static LootTable.Builder genEmpty(Block block)
    {
        return LootTable.builder();
    }

    protected static LootTable.Builder genCopyNbt(Block block, String... tags)
    {
        LootEntry.Builder<?> entry = ItemLootEntry.builder(block);
        CopyNbt.Builder func = CopyNbt.builder(CopyNbt.Source.BLOCK_ENTITY);

        for (String tag : tags)
        {
            func = func.replaceOperation(tag, "BlockEntityTag." + tag);
        }

        LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(entry).acceptCondition(SurvivesExplosion.builder()).acceptFunction(func);

        return LootTable.builder().addLootPool(pool);
    }

    protected static LootTable.Builder genSilkTouchableWithFortune(Block block, IItemProvider item, boolean applyFortune, int baseCount)
    {
        ItemPredicate.Builder silkPred = ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)));
        LootEntry.Builder<?> silk = ItemLootEntry.builder(block).acceptCondition(MatchTool.builder(silkPred));
        StandaloneLootEntry.Builder<?> nonSilk = ItemLootEntry.builder(item != null ? item : block);

        if (baseCount != 1)
        {
            nonSilk.acceptFunction(SetCount.builder(ConstantRange.of(baseCount)));
        }

        if (applyFortune)
        {
            nonSilk.acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE));
        }

        nonSilk.acceptFunction(ExplosionDecay.builder());

        LootEntry.Builder<?> entry = AlternativesLootEntry.builder(silk, nonSilk);
        LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(entry);

        return LootTable.builder().addLootPool(pool);
    }

    protected static LootTable.Builder genRegular(Block block)
    {
        LootEntry.Builder<?> entry = ItemLootEntry.builder(block);
        LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(entry).acceptCondition(SurvivesExplosion.builder());

        return LootTable.builder().addLootPool(pool);
    }
}
