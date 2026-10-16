package net.soybeans.tutorialmod;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = TutorialMod.MODID)
public class TutorialModDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {

    }

}
