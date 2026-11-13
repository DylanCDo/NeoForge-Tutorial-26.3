package net.soybeans.tutorialmod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.soybeans.tutorialmod.TutorialMod;
import net.soybeans.tutorialmod.item.custom.MetalDetectorItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MODID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.registerSimpleItem("bismuth");
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.registerSimpleItem("raw_bismuth");

    public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.registerItem("metal_detector",
            properties -> new MetalDetectorItem(properties.durability(64)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}