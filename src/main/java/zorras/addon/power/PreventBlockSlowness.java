package zorras.addon.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataType;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.LivingEntity;
import zorras.addon.ZorrasMod;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PreventBlockSlowness extends Power {

   private final Set<Block> blocks = new HashSet<>();
   private final boolean inverted;

   public PreventBlockSlowness(PowerType<?> type, LivingEntity entity, List<Block> blocks, boolean inverted) {
      super(type, entity);
      this.blocks.addAll(blocks);
      this.inverted = inverted;
   }

   public boolean shouldPreventSlowness(Block block) {
      if (inverted) {
         return !blocks.contains(block);
      }
      return blocks.contains(block);
   }

   public static final PowerFactory<?> getFactory() {
      return new PowerFactory<PreventBlockSlowness>(ZorrasMod.identifier("prevent_block_slowness"),
            new SerializableData()
                  .add("blocks", SerializableDataType.list(SerializableDataTypes.BLOCK), Collections.emptyList())
                  .add("inverted", SerializableDataTypes.BOOLEAN, false),
            data -> (type, entity) -> new PreventBlockSlowness(type, entity,
                  data.get("blocks"),
                  data.getBoolean("inverted")))
            .allowCondition();
   }
}
