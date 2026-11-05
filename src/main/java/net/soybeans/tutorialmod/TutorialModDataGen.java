
package net.soybeans.tutorialmod;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.soybeans.tutorialmod.datagen.ModBlockTagsProvider;
import net.soybeans.tutorialmod.datagen.ModModelProvider;

@EventBusSubscriber(modid = TutorialMod.MODID)

public class TutorialModDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        var lookupProvider = event.getReloadableLookupProvider();

        generator.addProvider(true, new ModModelProvider(packOutput));
        generator.addProvider(true, new ModBlockTagsProvider(packOutput, lookupProvider));
    }

}
