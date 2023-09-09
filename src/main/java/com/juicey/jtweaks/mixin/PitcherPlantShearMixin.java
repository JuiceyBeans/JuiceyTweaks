package com.juicey.jtweaks.mixin;

import com.juicey.jtweaks.access.PitcherCropBlockAccess;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PitcherCropBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ShearsItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.block.PitcherCropBlock.AGE;

@Mixin(ShearsItem.class)
public class PitcherPlantShearMixin {

    @Inject(method = "useOnBlock", at = @At(value = "RETURN"))
    public ActionResult useOnBlock(ItemUsageContext context, CallbackInfoReturnable info) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();
        if (block instanceof PitcherCropBlock pitcherCropBlock) {
            if (blockState.get(AGE) == 4) {
                PlayerEntity playerEntity = context.getPlayer();
                ItemStack itemStack = context.getStack();
                if (playerEntity instanceof ServerPlayerEntity) {
                    Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity) playerEntity, blockPos, itemStack);
                }

                world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_GROWING_PLANT_CROP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                BlockState blockState2 = ((PitcherCropBlockAccess) pitcherCropBlock).JuiceyTweaks$withMaxAge(blockState);
                world.setBlockState(blockPos, blockState2);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(context.getPlayer(), blockState2));
                if (playerEntity != null) {
                    itemStack.damage(1, playerEntity, (player) -> {
                        player.sendToolBreakStatus(context.getHand());
                    });
                }

                return ActionResult.success(world.isClient);
            }
        } return useOnBlock(context, info);
    }
}
