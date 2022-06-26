package zorras.addon.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.entity.LivingEntity;
import zorras.addon.ZorrasMod;

public class PreventSoulSandSlow extends Power {
   public PreventSoulSandSlow(PowerType<?> type, LivingEntity entity) {
      super(type, entity);
   }

   public boolean soulSandSlow() {
      return true;
   }

   public static PowerFactory<?> getFactory() {
      return new PowerFactory<>(ZorrasMod.identifier("prevent_soulsand_slow"),
            new SerializableData(),
            data -> (type, player) -> new PreventSoulSandSlow(type, player))
            .allowCondition();
   }
}
