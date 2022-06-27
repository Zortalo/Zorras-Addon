package zorras.addon.power;

import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.block.pattern.CachedBlockPosition;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import zorras.addon.ZorrasMod;

import java.util.function.Predicate;

public class ModifyBlockBounce extends Power {

   private final Predicate<CachedBlockPosition> blockCondition;
   private final float bounce;

   public ModifyBlockBounce(PowerType<?> type, LivingEntity entity, Predicate<CachedBlockPosition> predicate,
         float bounce) {
      super(type, entity);
      this.blockCondition = predicate;
      this.bounce = bounce;
   }

   public static final PowerType<Power> BOUNCE = new PowerTypeReference<>(new Identifier("zorras", "bounce"));

   public boolean doesApply(BlockPos pos) {
      CachedBlockPosition cbp = new CachedBlockPosition(entity.world, pos, true);
      return doesApply(cbp);
   }

   public boolean doesApply(CachedBlockPosition pos) {
      return blockCondition == null || blockCondition.test(pos);
   }

   public float getBouncy() {
      return bounce;
   }

   public static PowerFactory<?> getFactory() {
      return new PowerFactory<ModifyBlockBounce>(ZorrasMod.identifier("modify_bounce"),
            new SerializableData()
                  .add("block_condition", ApoliDataTypes.BLOCK_CONDITION, null)
                  .add("bounce", SerializableDataTypes.FLOAT, null),
            data -> (type, player) -> new ModifyBlockBounce(type, player,
                  data.get("block_condition"),
                  data.getFloat("bounce")))
            .allowCondition();

   }
}
