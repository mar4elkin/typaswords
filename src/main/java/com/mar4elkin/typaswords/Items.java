package com.mar4elkin.typaswords;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.util.EnumHelper;

public class Items {

    public static class CraftingRegister
    {
        public static void register()
        {
            registerRecipes("ultimatesword");
        }

        private static void registerRecipes(String name)
        {
            CraftingHelper.register(new ResourceLocation("typaswords", name), (IRecipeFactory) (context, json) -> CraftingHelper.getRecipe(json, context));
        }
    }

    public static final CreativeTabs CTAB = new CreativeTabs("typaswords")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(TypaSwords.ItemsRegistry.ULTIMATESWORD);
        }
    };

    public static class ItemKey extends Item {
        public ItemKey(String name) {
            this.setRegistryName(name);
            this.setUnlocalizedName(name);
            this.setCreativeTab(Items.CTAB);
        }
    }

    public static Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial("typaswords:tool", 2, 1024, 650.0F, 1200.0F, 42);

    public static class ItemBestSword extends ItemSword
    {
        public ItemBestSword(String name, Item.ToolMaterial material)
        {
            super(material);
            this.setRegistryName(name);
            this.setUnlocalizedName(name);
            this.setCreativeTab(Items.CTAB);
        }
    }

}
