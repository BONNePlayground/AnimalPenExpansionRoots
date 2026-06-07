package lv.id.bonne.animalpen.expansion.roots.provider;


import java.util.concurrent.CompletableFuture;

import lv.id.bonne.animalpen.expansion.roots.AnimalPenExpansionRoots;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AnimalPenExpansionRootsDataGen
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(),
            new ModAnimalInteractionProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeServer(),
            new ModEntityTypeTagProvider(packOutput,
                lookupProvider,
                AnimalPenExpansionRoots.MOD_ID,
                event.getExistingFileHelper()));
    }
}