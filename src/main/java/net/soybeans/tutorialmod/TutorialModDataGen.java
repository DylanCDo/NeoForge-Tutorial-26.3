
package net.soybeans.tutorialmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;
import net.soybeans.tutorialmod.datagen.ModBlockLootTableProvider;
import net.soybeans.tutorialmod.datagen.ModBlockTagsProvider;
import net.soybeans.tutorialmod.datagen.ModModelProvider;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = TutorialMod.MODID)

public class TutorialModDataGen {

    @SubscribeEvent
    public static void gatherDataRegistryEntries(GatherDataRegistryEntriesEvent event) {
        event.gatherFor(TutorialMod.MODID, Identifier.DEFAULT_NAMESPACE)
                .add(Registries.LOOT_TABLE, new LootTableProvider(Set.of(), List.of(
                        new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK))));
    }

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        var lookupProvider = event.getReloadableLookupProvider();

        generator.addProvider(true, new ModModelProvider(packOutput));
        generator.addProvider(true, new ModBlockTagsProvider(packOutput, lookupProvider));
    }

}
