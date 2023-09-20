package com.juicey.juiceytweaks.mixin;

import net.minecraft.item.ShearsItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ShearsItem.class)
public class ShearMixin {

    /*@Inject(method = "useOnBlock", at = @At(value = "RETURN"))
    public void shearPitcherPlant(ItemUsageContext context, CallbackInfoReturnable info) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();
        if (block instanceof PitcherCropBlock pitcherCropBlock) {
            if (blockState.get(AGE) != 4) {
                PlayerEntity playerEntity = context.getPlayer();
                ItemStack itemStack = context.getStack();
                if (playerEntity instanceof ServerPlayerEntity) {
                    Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
                }

                world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_GROWING_PLANT_CROP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                BlockState blockState2 = ((PitcherCropBlockAccess) pitcherCropBlock).JuiceyTweaks$isSheared(blockState);
                world.setBlockState(blockPos, blockState2);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(context.getPlayer(), blockState2));
                if (playerEntity != null) {
                    itemStack.damage(1, playerEntity, (player) -> {
                        player.sendToolBreakStatus(context.getHand());
                    });
                }
            }
        }
    }*/
}
