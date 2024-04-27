package com.juicey.juiceytweaks.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnowballEntity.class)
public abstract class SnowballFreezingMixin extends Entity {
    public SnowballFreezingMixin(EntityType<?> type, World world) {
        super(type, world);
    }

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
        Entity entity = entityHitResult.getEntity();
        entity.setFrozenTicks(300); //Gives freezing to the entity
        //Extinguishes the entity if it is on fire
        if (entity.wasOnFire) {
            entity.playSound(SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, 0.7F, 1.6F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
        }
        if (entity.isOnFire()) {
            entity.extinguishWithSound();
        }
    }
}