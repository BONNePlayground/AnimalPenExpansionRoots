package lv.id.bonne.animalpen.expansion.roots.provider;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import lv.id.bonne.animalpen.data.provider.AnimalInteractionProvider;
import lv.id.bonne.animalpen.expansion.roots.AnimalPenExpansionRoots;
import lv.id.bonne.animalpen.interaction.function.FunctionKey;
import lv.id.bonne.animalpen.interaction.ingredient.CustomIngredient;
import mysticmods.roots.api.RootsTags;
import mysticmods.roots.init.ModEntities;
import mysticmods.roots.init.ModSounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;


/**
 * Animal Interaction Data Provider.
 */
public class ModAnimalInteractionProvider extends AnimalInteractionProvider
{
    public ModAnimalInteractionProvider(PackOutput generator,
        CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(generator, lookupProvider);
        this.registry = lookupProvider;
    }


    @Override
    public CompletableFuture<?> run(CachedOutput cache)
    {
        return this.registry.thenCompose(provider ->
        {
            List<CompletableFuture<?>> futureList = new ArrayList<>();

            futureList.add(this.generateWithInteractions(cache,
                ModEntities.DUCK.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.DUCK_FOOD)),
                    this.generateAmbientSound(ModSounds.DUCK_AMBIENT.get())),
                "roots"));

            futureList.add(this.generateWithInteractions(cache,
                ModEntities.BEETLE.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.BEETLE_FOOD))),
                "roots"));

            futureList.add(this.generateWithInteractions(cache,
                ModEntities.DEER.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.DEER_FOOD)),
                    this.generateAmbientSound(ModSounds.DEER_AMBIENT.get())),
                "roots"));

            futureList.add(this.generateWithInteractions(cache,
                ModEntities.FENNEC.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.FENNEC_FOOD)),
                    this.generateAmbientSound(ModSounds.FENNEC_IDLE.get())),
                "roots"));


            futureList.add(this.generateWithInteractions(cache,
                ModEntities.TAN_SPROUT.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.SPROUT_FOOD),
                        FunctionKey.of(AnimalPenExpansionRoots.SPROUT_GIFT.get())),
                    this.generateAmbientSound(ModSounds.SPROUT_AMBIENT.get())),
                "roots"));

            futureList.add(this.generateWithInteractions(cache,
                ModEntities.PURPLE_SPROUT.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.SPROUT_FOOD),
                        FunctionKey.of(AnimalPenExpansionRoots.SPROUT_GIFT.get())),
                    this.generateAmbientSound(ModSounds.SPROUT_AMBIENT.get())),
                "roots"));

            futureList.add(this.generateWithInteractions(cache,
                ModEntities.GREEN_SPROUT.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.SPROUT_FOOD),
                        FunctionKey.of(AnimalPenExpansionRoots.SPROUT_GIFT.get())),
                    this.generateAmbientSound(ModSounds.SPROUT_AMBIENT.get())),
                "roots"));

            futureList.add(this.generateWithInteractions(cache,
                ModEntities.RED_SPROUT.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.SPROUT_FOOD),
                        FunctionKey.of(AnimalPenExpansionRoots.SPROUT_GIFT.get())),
                    this.generateAmbientSound(ModSounds.SPROUT_AMBIENT.get())),
                "roots"));

            futureList.add(this.generateWithInteractions(cache,
                ModEntities.SNOW_SPROUT.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.SPROUT_FOOD),
                        FunctionKey.of(AnimalPenExpansionRoots.SPROUT_GIFT.get())),
                    this.generateAmbientSound(ModSounds.SPROUT_AMBIENT.get())),
                "roots"));

            futureList.add(this.generateWithInteractions(cache,
                ModEntities.MELODY_SPROUT.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.SPROUT_FOOD),
                        FunctionKey.of(AnimalPenExpansionRoots.SPROUT_GIFT.get())),
                    this.generateAmbientSound(ModSounds.SPROUT_AMBIENT.get())),
                "roots"));

            futureList.add(this.generateWithInteractions(cache,
                ModEntities.JERBOA.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.JERBOA_FOOD))),
                "roots"));

            futureList.add(this.generateWithInteractions(cache,
                ModEntities.OWL.get(),
                List.of(this.generateFood(CustomIngredient.of(RootsTags.Items.OWL_FOOD))),
                "roots"));

            return CompletableFuture.allOf(futureList.toArray(CompletableFuture[]::new));
        });
    }


    private final CompletableFuture<HolderLookup.Provider> registry;
}