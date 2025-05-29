package net.ashe00.mgenewworld.item;

import net.ashe00.mgenewworld.MGENewWorld;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    //Creates a deferred register for items, this is the basis for creating all future items.
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MGENewWorld.MOD_ID);
    // these are the items that are created. They have no properties whatsoever at this point, and are completely useless without
    // outside code.

    // The items take in a name, which is their code ingame (/give), and a default list of item properties, which I assume I can change

    //realmsilver ingot processing:
    // realmsilver is a complicated material, and a powerful material at that. It is rare outside of the demonic landscape of
    // dark demon realms, and therefore difficult to forge.
    // Melting Requirements: Special Forge (Block)
    // Smithing Requirements: Iron+ Hammer, Template/Mold, Other Material; without template = 30-10% chance to forge, with = 95-72.
    // End Game processes to the metal can make even imperial mamono silver have 100% chance of forging
    // Smithing Block: Special Anvil (Block)
    // Other Resources: Mamono-Realm Copper, Mamono-Realm Iron, Mamono-Realm Steel, Imperial Mamono Silver (Highest Damage, perhaps 10)

    public static final DeferredItem<Item> MAMONO_SILVER = ITEMS.register("ingot_realmsilver", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MAMONO_SILVER_RAW = ITEMS.register("raw_realmsilver", () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);

    }
}
