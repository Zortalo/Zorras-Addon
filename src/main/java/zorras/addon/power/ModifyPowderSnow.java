package zorras.addon.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.entity.LivingEntity;
import zorras.addon.ZorrasMod;

public class ModifyPowderSnow extends Power {
   private final Boolean preventSink;
   private final Boolean preventSlowness;

   public ModifyPowderSnow(PowerType<?> type, LivingEntity entity, boolean preventSink, boolean preventSlowness) {
      super(type, entity);
      this.preventSink = preventSink;
      this.preventSlowness = preventSlowness;
   }

   public boolean doesPreventSink() {
      return preventSink;
   }

   public boolean doesPreventSlowness() {
      return preventSlowness;
   }

   public static PowerFactory<?> getFactory() {
      return new PowerFactory<ModifyPowderSnow>(ZorrasMod.identifier("modify_powder_snow"),
            new SerializableData()
                  .add("prevent_sink", SerializableDataTypes.BOOLEAN, true)
                  .add("prevent_slowness", SerializableDataTypes.BOOLEAN, false),
            data -> (type, player) -> new ModifyPowderSnow(type, player,
                  data.getBoolean("prevent_sink"),
                  data.getBoolean("prevent_slowness")))
            .allowCondition();
   }
}
