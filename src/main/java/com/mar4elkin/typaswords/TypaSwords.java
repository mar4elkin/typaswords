package com.mar4elkin.typaswords;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

import static com.mar4elkin.typaswords.Items.toolMaterial;

@Mod(modid = TypaSwords.MODID, name = TypaSwords.NAME, version = TypaSwords.VERSION)
public class TypaSwords
{
    public static final String MODID = "typaswords";
    public static final String NAME = "Typa Swords";
    public static final String VERSION = "0.0.1";
    private static Logger logger;

    @GameRegistry.ObjectHolder(MODID)
    @Mod.EventBusSubscriber// Автоматическая регистрация статичных обработчиков событий
    public static class ItemsRegistry {

        @GameRegistry.ObjectHolder("sukaingot")
        public static final Item SUKAINGOT = null;

        @GameRegistry.ObjectHolder("ultimatesword")
        public static final Item ULTIMATESWORD = null;

        @SubscribeEvent
        public static void onRegistryItem(RegistryEvent.Register<Item> e) {
            e.getRegistry().register(new Items.ItemKey("sukaingot"));
            e.getRegistry().register(new Items.ItemBestSword("ultimatesword", toolMaterial));
        }

        @SideOnly(Side.CLIENT)
        private static void registryModel(Item item) {
            final ResourceLocation regName = item.getRegistryName();// Не забываем, что getRegistryName может вернуть Null!
            final ModelResourceLocation mrl = new ModelResourceLocation(regName, "inventory");
            ModelBakery.registerItemVariants(item, mrl);// Регистрация вариантов предмета. Это нужно если мы хотим использовать подтипы предметов/блоков(см. статью подтипы)
            ModelLoader.setCustomModelResourceLocation(item, 0, mrl);// Устанавливаем вариант модели для нашего предмета. Без регистрации варианта модели, сама модель не будет установлена для предмета/блока(см. статью подтипы)
        }

        @SubscribeEvent
        @SideOnly(Side.CLIENT)
        public static void onRegistryModel(ModelRegistryEvent e) {
            registryModel(SUKAINGOT);
            registryModel(ULTIMATESWORD);
        }
    }


}
