package com.juicey.juiceytweaks.mixin;

import com.juicey.juiceytweaks.accessor.PitcherCropBlockAccessor;
import net.minecraft.block.PitcherCropBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PitcherCropBlock.class)
public abstract class PitcherCropMixin implements PitcherCropBlockAccessor {

    /*@Unique
    private static final BooleanProperty NOT_SHEARED;
    static {
        NOT_SHEARED = BooleanProperty.of("not_sheared");
    }

    @Inject(method = "appendProperties", at = @At(value = "TAIL", target = "Lnet/minecraft/block/PitcherCropBlock;appendProperties(Lnet/minecraft/state/StateManager$Builder;)V", ordinal = 0))
    private void addShearedProperty(StateManager.Builder<Block, BlockState> builder, CallbackInfo info) {
        builder.add(NOT_SHEARED);
    }

    @WrapWithCondition(
            method = "randomTick",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/block/PitcherCropBlock;tryGrow(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;I)V")
    )
    private boolean shearCheck(boolean bl) {
        return bl && NOT_SHEARED;

    }*/
}