package zorras.addon.conditions;

import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.entity.Entity;

public class InSnowCondition {
   public static boolean condition(SerializableData.Instance data, Entity entity) {
      if (entity.getEntityWorld().isClient()) return false;
      return false;
   }

   public static ConditionFactory<Entity> getFactory() {
      return null;
   }
}
