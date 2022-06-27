package zorras.addon.mixin;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.BlockView;
import zorras.addon.power.*;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin {
   @Inject(method = "onEntityLand", at = @At("HEAD"), cancellable = true)
   public void onEntityLand(BlockView world, Entity entity, CallbackInfo ci) {
      if (ModifyBlockBounce.BOUNCE.isActive(entity) && !entity.bypassesLandingEffects()) {
         entity.setVelocity(entity.getVelocity().multiply(1.0F, -0.85, 1.0F));
         ci.cancel();
         return;
      }
   }
}
