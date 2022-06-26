package zorras.addon.registry.condition;

import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.entity.Entity;
import net.minecraft.util.registry.Registry;
import zorras.addon.conditions.*;

public class ZorrasEntityConditions {
   public static void register() {
      register(InSnowCondition.getFactory());
   }

   private static void register(ConditionFactory<Entity> conditionFactory) {
      Registry.register(ApoliRegistries.ENTITY_CONDITION, conditionFactory.getSerializerId(), conditionFactory);
   }
}
