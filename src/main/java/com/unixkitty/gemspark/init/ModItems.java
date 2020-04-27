package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.util.Gem;
import com.unixkitty.gemspark.util.GemItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Gemspark.MODID);

    public static final RegistryObject<Item> nbt_stick = GemItems.registerDebugItem();

    public static final RegistryObject<Item> TANZANITE = GemItems.registerGemItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ = GemItems.registerGemItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE = GemItems.registerGemItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE = GemItems.registerGemItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY = GemItems.registerGemItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_AXE = GemItems.registerAxeItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ_AXE = GemItems.registerAxeItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE_AXE = GemItems.registerAxeItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE_AXE = GemItems.registerAxeItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY_AXE = GemItems.registerAxeItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_SWORD = GemItems.registerSwordItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ_SWORD = GemItems.registerSwordItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE_SWORD = GemItems.registerSwordItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE_SWORD = GemItems.registerSwordItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY_SWORD = GemItems.registerSwordItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_SHOVEL = GemItems.registerShovelItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ_SHOVEL = GemItems.registerShovelItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = GemItems.registerShovelItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE_SHOVEL = GemItems.registerShovelItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY_SHOVEL = GemItems.registerShovelItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_PICKAXE = GemItems.registerPickaxeItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ_PICKAXE = GemItems.registerPickaxeItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = GemItems.registerPickaxeItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE_PICKAXE = GemItems.registerPickaxeItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY_PICKAXE = GemItems.registerPickaxeItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_HOE = GemItems.registerHoeItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ_HOE = GemItems.registerHoeItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE_HOE = GemItems.registerHoeItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE_HOE = GemItems.registerHoeItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY_HOE = GemItems.registerHoeItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_HELMET = GemItems.registerArmorItem(Gem.TANZANITE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> TOPAZ_HELMET = GemItems.registerArmorItem(Gem.TOPAZ, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> SAPPHIRE_HELMET = GemItems.registerArmorItem(Gem.SAPPHIRE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> PINK_SAPPHIRE_HELMET = GemItems.registerArmorItem(Gem.PINK_SAPPHIRE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> RUBY_HELMET = GemItems.registerArmorItem(Gem.RUBY, EquipmentSlotType.HEAD);

    public static final RegistryObject<Item> TANZANITE_CHESTPLATE = GemItems.registerArmorItem(Gem.TANZANITE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> TOPAZ_CHESTPLATE = GemItems.registerArmorItem(Gem.TOPAZ, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = GemItems.registerArmorItem(Gem.SAPPHIRE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> PINK_SAPPHIRE_CHESTPLATE = GemItems.registerArmorItem(Gem.PINK_SAPPHIRE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> RUBY_CHESTPLATE = GemItems.registerArmorItem(Gem.RUBY, EquipmentSlotType.CHEST);

    public static final RegistryObject<Item> TANZANITE_LEGGINGS = GemItems.registerArmorItem(Gem.TANZANITE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> TOPAZ_LEGGINGS = GemItems.registerArmorItem(Gem.TOPAZ, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = GemItems.registerArmorItem(Gem.SAPPHIRE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> PINK_SAPPHIRE_LEGGINGS = GemItems.registerArmorItem(Gem.PINK_SAPPHIRE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> RUBY_LEGGINGS = GemItems.registerArmorItem(Gem.RUBY, EquipmentSlotType.LEGS);

    public static final RegistryObject<Item> TANZANITE_BOOTS = GemItems.registerArmorItem(Gem.TANZANITE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> TOPAZ_BOOTS = GemItems.registerArmorItem(Gem.TOPAZ, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = GemItems.registerArmorItem(Gem.SAPPHIRE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> PINK_SAPPHIRE_BOOTS = GemItems.registerArmorItem(Gem.PINK_SAPPHIRE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> RUBY_BOOTS = GemItems.registerArmorItem(Gem.RUBY, EquipmentSlotType.FEET);
}
