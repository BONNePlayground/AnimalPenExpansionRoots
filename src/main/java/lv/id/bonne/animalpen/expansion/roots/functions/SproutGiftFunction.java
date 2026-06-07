//
// Created by BONNe
// Copyright - 2026
//


package lv.id.bonne.animalpen.expansion.roots.functions;


import org.jetbrains.annotations.Nullable;

import lv.id.bonne.animalpen.expansion.roots.mixin.SproutEntityAccessor;
import lv.id.bonne.animalpen.interaction.value.Value;
import lv.id.bonne.animalpen.items.component.StoredMobData;
import lv.id.bonne.animalpen.processing.function.api.EntityFunction;
import lv.id.bonne.animalpen.registries.AnimalPenDataComponentRegistry;
import lv.id.bonne.animalpen.util.AnimalPenCompoundTags;
import lv.id.bonne.animalpen.util.ItemTransferUtil;
import mysticmods.roots.entity.SproutEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;


public class SproutGiftFunction implements EntityFunction
{
    @Override
    public boolean processFunction(ServerLevel serverLevel,
        Mob mob,
        ItemStack componentHolder,
        BlockPos blockPos,
        @Nullable String dataKey,
        @Nullable Value dataValue)
    {
        if (!(mob instanceof SproutEntity entity))
        {
            return false;
        }

        StoredMobData storedMobData = componentHolder.get(AnimalPenDataComponentRegistry.MOB_DATA_COMPONENT.get());

        if (storedMobData == null)
        {
            return false;
        }

        for (int i = 0; i < storedMobData.properties().getOrDefault(AnimalPenCompoundTags.TAG_LAST_FEEDING_AMOUNT, 0); i++)
        {
            ItemStack stack = ((SproutEntityAccessor) entity).callGetGift();

            if (!stack.isEmpty())
            {
                ItemTransferUtil.insertBellowOrDrop(serverLevel, stack, blockPos, blockPos.above());
            }
        }

        return false;
    }
}
