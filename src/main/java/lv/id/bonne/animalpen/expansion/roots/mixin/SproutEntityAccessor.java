//
// Created by BONNe
// Copyright - 2026
//


package lv.id.bonne.animalpen.expansion.roots.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import mysticmods.roots.entity.SproutEntity;
import net.minecraft.world.item.ItemStack;


@Mixin(value = SproutEntity.class, remap = false)
public interface SproutEntityAccessor
{
    @Invoker("getGift")
    ItemStack callGetGift();
}
