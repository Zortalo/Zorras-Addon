package zorras.addon.mixin;

import zorras.addon.power.PowderSnowSink;
import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PowderSnowBlock.class)
public class PowderSnowMixin {
	@Inject(method = "canWalkOnPowderSnow", at = @At("HEAD"), cancellable = true)
	private static void zorras$canWalkOnPowderSnow(Entity entity, CallbackInfoReturnable<Boolean> cir) {
		for (PowderSnowSink powderSnowSink : PowerHolderComponent.getPowers(entity, PowderSnowSink.class)) {
			if (powderSnowSink.isActive()) {
				cir.setReturnValue(true);
				return;
			}
		}
	}
}