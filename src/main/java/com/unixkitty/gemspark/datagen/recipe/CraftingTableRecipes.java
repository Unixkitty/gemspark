package com.unixkitty.gemspark.datagen.recipe;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.item.Gem;
import com.unixkitty.gemspark.item.GemItems;
import com.unixkitty.gemspork.lib.HelperUtil;
import com.unixkitty.gemspork.lib.datagen.recipe.CraftingTableRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class CraftingTableRecipes extends CraftingTableRecipeProvider
{
    public CraftingTableRecipes(DataGenerator generator)
    {
        super(Gemspark.MODID, generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        registerSimpleArmorSet(consumer, Gem.TANZANITE.getItemTag());
        registerSimpleArmorSet(consumer, Gem.TOPAZ.getItemTag());
        registerSimpleArmorSet(consumer, Gem.SAPPHIRE.getItemTag());
        registerSimpleArmorSet(consumer, Gem.PINK_SAPPHIRE.getItemTag());
        registerSimpleArmorSet(consumer, Gem.RUBY.getItemTag());

        registerToolSetRecipes(consumer, Gem.TANZANITE.getItemTag());
        registerToolSetRecipes(consumer, Gem.TOPAZ.getItemTag());
        registerToolSetRecipes(consumer, Gem.SAPPHIRE.getItemTag());
        registerToolSetRecipes(consumer, Gem.PINK_SAPPHIRE.getItemTag());
        registerToolSetRecipes(consumer, Gem.RUBY.getItemTag());

        registerCompression(consumer, Gem.TANZANITE.getItemTag());
        registerCompression(consumer, Gem.TOPAZ.getItemTag());
        registerCompression(consumer, Gem.SAPPHIRE.getItemTag());
        registerCompression(consumer, Gem.PINK_SAPPHIRE.getItemTag());
        registerCompression(consumer, Gem.RUBY.getItemTag());

        registerLantern(consumer, Gem.TANZANITE.getItemTag());
        registerLantern(consumer, Gem.TOPAZ.getItemTag());
        registerLantern(consumer, Gem.SAPPHIRE.getItemTag());
        registerLantern(consumer, Gem.PINK_SAPPHIRE.getItemTag());
        registerLantern(consumer, Gem.RUBY.getItemTag());
        registerLantern(consumer, Tags.Items.GEMS_EMERALD);
        registerLantern(consumer, Tags.Items.GEMS_DIAMOND);

        registerUniqueRecipes(consumer);

        registerColoredLamp(consumer, false);
        registerColoredLamp(consumer, true);

        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_OAK.get(), Blocks.OAK_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_NETHER_BRICK.get(), Blocks.NETHER_BRICK_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_SPRUCE.get(), Blocks.SPRUCE_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_BIRCH.get(), Blocks.BIRCH_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_JUNGLE.get(), Blocks.JUNGLE_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_ACACIA.get(), Blocks.ACACIA_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_DARK_OAK.get(), Blocks.DARK_OAK_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_WARPED.get(), Blocks.WARPED_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_CRIMSON.get(), Blocks.CRIMSON_FENCE);
    }

    private void registerColoredLamp(Consumer<IFinishedRecipe> consumer, boolean inverted)
    {
        IItemProvider output;
        Ingredient dustOrTorchIngredient;

        for (DyeColor color : DyeColor.values())
        {
            output = GemItems.coloredLampFromDye(color, inverted);
            dustOrTorchIngredient = (inverted ? Ingredient.fromItems(Blocks.REDSTONE_TORCH) : Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE));

            ShapedRecipeBuilder.shapedRecipe(output)
                    .key('g', Tags.Items.DUSTS_GLOWSTONE)
                    .key('P', ItemTags.makeWrapperTag("forge" + ":" + "glass_panes/" + color.toString()))
                    .key('R', dustOrTorchIngredient)
                    .patternLine("PgP")
                    .patternLine("PgP")
                    .patternLine("PRP")
                    .addCriterion("has_item", hasItem(Tags.Items.DUSTS_REDSTONE))
                    .build(consumer);
        }
    }

    private void registerUniqueRecipes(Consumer<IFinishedRecipe> consumer)
    {
        //Stone Tiles
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.STONE_TILES.get(), 4)
                .key('S', Blocks.SMOOTH_STONE)
                .patternLine("SS")
                .patternLine("SS")
                .addCriterion("has_item", hasItem(Blocks.SMOOTH_STONE))
                .build(consumer);

        //Stone Floor Tile
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.STONE_FLOOR_TILE.get())
                .key('S', Blocks.SMOOTH_STONE)
                .key('s', Blocks.SMOOTH_STONE_SLAB)
                .patternLine("sS")
                .patternLine("Ss")
                .addCriterion("has_item", hasItem(Blocks.SMOOTH_STONE))
                .build(consumer);

        //Rocky Grassy Dirt
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.ROCKY_GRASSY_DIRT.get(), 4)
                .key('c', Tags.Items.COBBLESTONE)
                .key('d', Blocks.DIRT)
                .patternLine("dd")
                .patternLine("cd")
                .addCriterion("has_item", hasItem(Blocks.DIRT))
                .build(consumer);

        //Rocky Dirt
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.ROCKY_DIRT.get(), 4)
                .key('c', Tags.Items.COBBLESTONE)
                .key('d', Blocks.DIRT)
                .patternLine("cd")
                .patternLine("dc")
                .addCriterion("has_item", hasItem(Blocks.DIRT))
                .build(consumer);

        //Dark Rocky Dirt
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.DARK_ROCKY_DIRT.get(), 4)
                .key('c', Tags.Items.COBBLESTONE)
                .key('d', Blocks.DIRT)
                .patternLine("cd")
                .patternLine("cc")
                .addCriterion("has_item", hasItem(Blocks.DIRT))
                .build(consumer);

        //Soul Brazier
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.SOUL_BRAZIER.get())
                .key('b', Blocks.IRON_BARS)
                .key('s', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .key('i', Tags.Items.INGOTS_IRON)
                .patternLine("bsb")
                .patternLine(" i ")
                .patternLine("i i")
                .addCriterion("has_item", hasItem(Tags.Items.INGOTS_IRON))
                .build(consumer);

        //Brazier
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.BRAZIER.get())
                .key('b', Blocks.IRON_BARS)
                .key('c', ItemTags.COALS)
                .key('i', Tags.Items.INGOTS_IRON)
                .patternLine("bcb")
                .patternLine(" i ")
                .patternLine("i i")
                .addCriterion("has_item", hasItem(Tags.Items.INGOTS_IRON))
                .build(consumer);

        //Tiara
        ShapedRecipeBuilder.shapedRecipe(ModItems.TIARA.get())
                .key('t', Gem.TANZANITE.getItemTag())
                .key('c', ModItems.COSMETIC_CLAY.get())
                .key('g', Tags.Items.NUGGETS_GOLD)
                .patternLine("ggg")
                .patternLine("gcg")
                .patternLine("ttt")
                .addCriterion("has_item", hasItem(ModItems.TANZANITE.get()))
                .build(consumer);

        //Spitfire Cap with spectacles
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.SPITFIRECAP_SPECS.get())
                .addIngredient(ModItems.SPECTACLES.get())
                .addIngredient(ModItems.SPITFIRECAP.get())
                .addCriterion("has_spectacles", hasItem(ModItems.SPECTACLES.get()))
                .addCriterion("has_spitfirecap", hasItem(ModItems.SPITFIRECAP.get()))
                .build(consumer);

        //Spitfire Cap
        ShapedRecipeBuilder.shapedRecipe(ModItems.SPITFIRECAP.get())
                .key('l', Items.LEATHER)
                .key('c', ModItems.COSMETIC_CLAY.get())
                .key('g', Tags.Items.NUGGETS_GOLD)
                .patternLine("lll")
                .patternLine("lcl")
                .patternLine("  g")
                .addCriterion("has_item", hasItem(ModItems.COSMETIC_CLAY.get()))
                .build(consumer);

        //Pink Ribbon
        ShapedRecipeBuilder.shapedRecipe(ModItems.REDBACKRIBBON.get())
                .key('w', Blocks.PINK_WOOL)
                .key('c', ModItems.COSMETIC_CLAY.get())
                .patternLine("w w")
                .patternLine("wcw")
                .addCriterion("has_item", hasItem(ModItems.COSMETIC_CLAY.get()))
                .build(consumer);

        //Headphones
        ShapedRecipeBuilder.shapedRecipe(ModItems.HEADPHONES.get())
                .key('w', Blocks.WHITE_WOOL)
                .key('c', ModItems.COSMETIC_CLAY.get())
                .key('b', Blocks.BLACK_WOOL)
                .patternLine("www")
                .patternLine("bcb")
                .addCriterion("has_item", hasItem(ModItems.COSMETIC_CLAY.get()))
                .build(consumer);

        //Straw Hat
        ShapedRecipeBuilder.shapedRecipe(ModItems.FARMER_HAT.get())
                .key('w', Items.WHEAT)
                .key('c', ModItems.COSMETIC_CLAY.get())
                .patternLine("www")
                .patternLine("wcw")
                .patternLine("www")
                .addCriterion("has_item", hasItem(ModItems.COSMETIC_CLAY.get()))
                .build(consumer);

        //False Halo
        ShapedRecipeBuilder.shapedRecipe(ModItems.FALSE_HALO.get())
                .key('g', Tags.Items.INGOTS_GOLD)
                .key('c', ModItems.COSMETIC_CLAY.get())
                .patternLine(" g ")
                .patternLine("gcg")
                .patternLine(" g ")
                .addCriterion("has_item", hasItem(ModItems.COSMETIC_CLAY.get()))
                .build(consumer);

        //Bunny Ears
        ShapedRecipeBuilder.shapedRecipe(ModItems.BUNNYBAND.get())
                .key('w', Blocks.WHITE_WOOL)
                .key('c', ModItems.COSMETIC_CLAY.get())
                .key('r', Items.RABBIT_HIDE)
                .patternLine("w w")
                .patternLine(" c ")
                .patternLine(" r ")
                .addCriterion("has_item", hasItem(Items.RABBIT_HIDE))
                .build(consumer);

        //Witch Hat
        ShapedRecipeBuilder.shapedRecipe(ModItems.WITCH_HAT.get())
                .key('s', Tags.Items.STRING)
                .key('t', Gem.TANZANITE.getItemTag())
                .key('b', Blocks.BLACK_WOOL)
                .key('c', ModItems.COSMETIC_CLAY.get())
                .key('p', Blocks.PURPLE_WOOL)
                .patternLine(" st")
                .patternLine("bc ")
                .patternLine("pp ")
                .addCriterion("has_item", hasItem(Items.STICK))
                .build(consumer);

        //Cosmetic Clay
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.COSMETIC_CLAY.get(), 4)
                .addIngredient(Items.CLAY_BALL)
                .addIngredient(Tags.Items.DYES_RED)
                .addIngredient(Tags.Items.DYES_GREEN)
                .addIngredient(Tags.Items.DYES_BLUE)
                .addIngredient(Gem.TANZANITE.getItemTag())
                .addCriterion("has_clay", hasItem(Items.CLAY))
                .build(consumer);

        //Red glasses
        ShapedRecipeBuilder.shapedRecipe(ModItems.GLASSES_RED.get())
                .key('s', Gem.RUBY.getItemTag())
                .key('P', Tags.Items.GLASS_PANES_COLORLESS)
                .patternLine(" s ")
                .patternLine("P P")
                .addCriterion("has_item", hasItem(Gem.RUBY.getItemTag()))
                .build(consumer);

        //Wood Golem
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.WOOD_GOLEM_RELIC.get())
                .key('s', Items.STICK)
                .key('p', Blocks.SPRUCE_PLANKS)
                .key('c', ModItems.COSMETIC_CLAY.get())
                .patternLine(" p ")
                .patternLine("sps")
                .patternLine("scs")
                .addCriterion("has_item", hasItem(ModItems.COSMETIC_CLAY.get()))
                .build(consumer);

        //Quartz Pedestal
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.QUARTZ_PEDESTAL.get())
                .key('s', Blocks.QUARTZ_SLAB)
                .key('p', Blocks.QUARTZ_PILLAR)
                .patternLine("s")
                .patternLine("p")
                .addCriterion("has_item", hasItem(Tags.Items.GEMS_QUARTZ))
                .build(consumer);

        //Blackstone Pedestal
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.BLACKSTONE_PEDESTAL.get())
                .key('s', Blocks.BLACKSTONE_SLAB)
                .key('p', Blocks.POLISHED_BLACKSTONE)
                .patternLine("s")
                .patternLine("p")
                .addCriterion("has_item", hasItem(Items.BLACKSTONE))
                .build(consumer);

        //Spectacles
        ShapedRecipeBuilder.shapedRecipe(ModItems.SPECTACLES.get())
                .key('s', Gem.SAPPHIRE.getItemTag())
                .key('P', Tags.Items.GLASS_PANES_COLORLESS)
                .patternLine(" s ")
                .patternLine("P P")
                .addCriterion("has_item", hasItem(Gem.SAPPHIRE.getItemTag()))
                .build(consumer);

        //Technicolor glasses
        ShapedRecipeBuilder.shapedRecipe(ModItems.GLASSES_TECHNICOLOR.get())
                .key('r', Gem.RUBY.getItemTag())
                .key('g', Tags.Items.GEMS_EMERALD)
                .key('b', Gem.SAPPHIRE.getItemTag())
                .key('R', Tags.Items.GLASS_PANES_CYAN)
                .key('L', Tags.Items.GLASS_PANES_YELLOW)
                .patternLine("rgb")
                .patternLine("R L")
                .addCriterion("has_item", hasItem(Tags.Items.GEMS_EMERALD))
                .build(consumer);

        //3D glasses
        ShapedRecipeBuilder.shapedRecipe(ModItems.GLASSES_3D.get())
                .key('p', Ingredient.fromItems(Items.PAPER))
                .key('R', Tags.Items.GLASS_PANES_BLUE)
                .key('L', Tags.Items.GLASS_PANES_RED)
                .patternLine("ppp")
                .patternLine("R L")
                .addCriterion("has_item", hasItem(Tags.Items.GLASS_PANES_BLUE))
                .build(consumer);
    }

    private void registerLantern(Consumer<IFinishedRecipe> consumer, ITag.INamedTag<Item> gemIngredient)
    {
        IItemProvider output = HelperUtil.itemFromMaterialTag(gemIngredient, Gemspark.MODID, "lantern");

        ShapedRecipeBuilder.shapedRecipe(output, Config.GEMLANTERNSFROMCRAFT)
                .key('g', gemIngredient)
                .key('d', Tags.Items.DUSTS_GLOWSTONE)
                .key('G', Tags.Items.GLASS_COLORLESS)
                .patternLine("gdg")
                .patternLine("dGd")
                .patternLine("gdg")
                .addCriterion("has_item", hasItem(gemIngredient))
                .build(consumer);
    }

    private void registerLampPostCap(Consumer<IFinishedRecipe> consumer, Block lampPostCap, Block fence)
    {
        ShapedRecipeBuilder.shapedRecipe(lampPostCap)
                .key('i', Tags.Items.INGOTS_IRON)
                .key('F', fence)
                .patternLine("ii ")
                .patternLine("iF ")
                .patternLine("  i")
                .addCriterion("has_item", hasItem(fence))
                .build(consumer);
    }
}
