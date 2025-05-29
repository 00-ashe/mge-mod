package net.ashe00.mgenewworld.item;

import net.ashe00.mgenewworld.MGENewWorld;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    // create deferred register of type CreativeModeTab called CREATIVE_MODE_TAB. This is a general register
    // used to then base other tabs off of
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MGENewWorld.MOD_ID);

    // large command to create the creative mode tab. tab ID = MGE_Materials, usable name is tab_mge_materials.
    // Takes in a supplier that builds a Creative Mode Tab with these parameters:
    //      icon: Set to Unrefined Realm Silver
    //      title: set to a translatable component (to be added to en_us.json)
    //      displayItems: Will display the items we list inside of this supplier
    // build method creates the full tab.
    public static final Supplier<CreativeModeTab> MGE_MATERIALS = CREATIVE_MODE_TAB.register("tab_mge_materials",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MAMONO_SILVER_RAW.get()))
                    .title(Component.translatable("creativetab.mgenewworld.mge_materials"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MAMONO_SILVER_RAW);
                        output.accept(ModItems.MAMONO_SILVER);
                    })
                    .build());
    // large command to create the creative mode tab. tab ID = MGE_BLOCKS, usable name is tab_mge_blocks.
    // Takes in a supplier that builds a Creative Mode Tab with these parameters:
    //      icon: Set to Refined Realm Silver
    //      withTabsBefore: Will make sure this tab is put after the listed tabs before it.
    //      title: set to a translatable component (to be added to en_us.json)
    //      displayItems: Will display the items we list inside of this supplier
    // build method creates the full tab.
    public static final Supplier<CreativeModeTab> MGE_BLOCKS = CREATIVE_MODE_TAB.register("tab_mge_blocks",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MAMONO_SILVER.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MGENewWorld.MOD_ID, "tab_mge_materials"))
                    .title(Component.translatable("creativetab.mgenewworld.mge_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // put building blocks and other blocks here.
                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
