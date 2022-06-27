package zorras.addon.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import zorras.addon.power.*;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
   @Inject(method = "canBeRiddenInWater", at = @At("HEAD"), cancellable = true)
   private void zorras$rideInWater(CallbackInfoReturnable<Boolean> zx) {
      PowerHolderComponent.getPowers(Entity.class.cast(this), RideUnderWater.class).forEach(canRideUnderWater -> {
         zx.setReturnValue(true);
      });
   }
}
