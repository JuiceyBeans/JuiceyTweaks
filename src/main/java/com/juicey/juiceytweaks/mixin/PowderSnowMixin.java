package com.juicey.juiceytweaks.mixin;

import com.juicey.juiceytweaks.JuiceyTweaks;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PowderSnowBlock.class)
public class PowderSnowMixin {
    @ModifyExpressionValue(
            method = "canWalkOnPowderSnow(Lnet/minecraft/entity/Entity;)Z",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
            )
    )
    private static boolean allowFrostWalker(boolean original, Entity entity) {
        return original || powderSnowWalkCondition(entity);
    }

    private static boolean powderSnowWalkCondition(Entity entity) {
        if(EnchantmentHelper.getEquipmentLevel(Enchantments.FROST_WALKER, ((LivingEntity)entity)) > 0) {
            return true;
        } else return false;
    };
}
