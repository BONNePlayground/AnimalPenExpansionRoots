//
// Created by BONNe
// Copyright add(ModEntities.2025
//


package lv.id.bonne.animalpen.expansion.roots.provider;


import lv.id.bonne.animalpen.data.helper.SimpleTagAppender;
import lv.id.bonne.animalpen.registries.AnimalPenTags;
import mysticmods.roots.init.ModEntities;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;


@FunctionalInterface
public interface ModEntityTypeTagsProvider
{
    SimpleTagAppender<EntityType<?>> modTag(TagKey<EntityType<?>> tag);


    default void addModTags()
    {
        this.modTag(AnimalPenTags.ANIMAL_CAGE_PICKABLE).
            add(ModEntities.DUCK.get()).
            add(ModEntities.BEETLE.get()).
            add(ModEntities.DEER.get()).
            add(ModEntities.FENNEC.get()).
            add(ModEntities.TAN_SPROUT.get()).
            add(ModEntities.GREEN_SPROUT.get()).
            add(ModEntities.RED_SPROUT.get()).
            add(ModEntities.SNOW_SPROUT.get()).
            add(ModEntities.PURPLE_SPROUT.get()).
            add(ModEntities.MELODY_SPROUT.get()).
            add(ModEntities.JERBOA.get());
        this.modTag(AnimalPenTags.BIRD_CATCHER_PICKABLE).
            add(ModEntities.OWL.get());
    }
}
