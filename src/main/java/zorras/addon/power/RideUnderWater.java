package zorras.addon.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.entity.LivingEntity;
import zorras.addon.ZorrasMod;

public class RideUnderWater extends Power {
   public RideUnderWater(PowerType<?> type, LivingEntity entity) {
      super(type, entity);
   }

   public boolean canRide() {
      return true;
   }

   public static PowerFactory<?> getFactory() {
      return new PowerFactory<>(ZorrasMod.identifier("ride_underwater"),
            new SerializableData(),
            data -> (type, player) -> new RideUnderWater(type, player))
            .allowCondition();
   }
}
