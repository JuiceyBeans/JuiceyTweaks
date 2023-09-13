package com.juicey.jtweaks.mixin;

import net.minecraft.item.FoodComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import static org.objectweb.asm.Opcodes.PUTSTATIC;

@Mixin(FoodComponents.class)
public class CookieMixin {

    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(
                            value = "FIELD",
                            target = "Lnet/minecraft/item/FoodComponents;COOKED_SALMON:Lnet/minecraft/item/FoodComponent;",
                            opcode = PUTSTATIC
                    )
            ),
            at = @At(
                    value="INVOKE",
                    target = "Lnet/minecraft/item/FoodComponent$Builder;saturationModifier(F)Lnet/minecraft/item/FoodComponent$Builder;"
            )
    )
    private static float saturationModifier(float value) {
        return 1F;
    }

    @ModifyArg(
            method = "<clinit>",
            slice = @Slice(
                    from = @At(
                            value = "FIELD",
                            target = "Lnet/minecraft/item/FoodComponents;COOKED_SALMON:Lnet/minecraft/item/FoodComponent;",
                            opcode = PUTSTATIC
                    )
            ),
            at = @At(
                    value="INVOKE",
                    target = "Lnet/minecraft/item/FoodComponent$Builder;hunger(I)Lnet/minecraft/item/FoodComponent$Builder;",
                    ordinal = 0
            )
    )
    private static int hunger(int value) {
        return 3;
    }
}
