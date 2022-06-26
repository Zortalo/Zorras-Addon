package zorras.addon.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.block.SoulSandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import zorras.addon.power.*;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.apace100.apoli.component.PowerHolderComponent;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "slowMovement", at = @At("HEAD"), cancellable = true)
    private void zorras$slowMovement(BlockState state, Vec3d multiplier, CallbackInfo cir) {
        Entity entity = (Entity) (Object) this;

        Block powdersnow = state.getBlock();
        if (powdersnow instanceof PowderSnowBlock) {

            for (ModifyPowderSnow powderSnowSlow : PowerHolderComponent.getPowers(entity, ModifyPowderSnow.class)) {
                if (powderSnowSlow.doesPreventSlowness()) {
                    cir.cancel();
                }
            }
        }
        Block soulsand = state.getBlock();
        if (soulsand instanceof SoulSandBlock) {
            for (PreventSoulSandSlow soulSandSlow : PowerHolderComponent.getPowers(entity, PreventSoulSandSlow.class)) {
                if (soulSandSlow.soulSandSlow())
                    cir.cancel();
            }
        }
    }

    @Inject(method = "canBeRiddenInWater", at = @At("HEAD"), cancellable = true)
    private boolean canRideUnderWater() {
        return true;
    }
}
