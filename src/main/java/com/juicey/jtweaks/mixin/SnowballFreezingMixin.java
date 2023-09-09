package com.juicey.jtweaks.mixin;

import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(SnowballEntity.class)
public abstract class SnowballFreezingMixin {

    /* Used to make snowballs do damage to all mobs, not what I want but might be useful for future reference
    @ModifyConstant(
            method = "onEntityHit",
            constant = @Constant(intValue = 0)
    )
    private int i(int value) {
        return 1;
    }*/

    @Inject(method = "onEntityHit", at = @At(value = "TAIL"))
    private void setFreezing(EntityHitResult entityHitResult, CallbackInfo info) {
        entityHitResult.getEntity().setFrozenTicks(300);
    }
}