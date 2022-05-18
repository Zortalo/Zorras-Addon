package zorras.addon.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.entity.LivingEntity;
import zorras.addon.ZorrasMod;

public class PowderSnowSink extends Power {
	public PowderSnowSink(PowerType<?> type, LivingEntity entity) {
		super(type, entity);
	}

   public static PowerFactory<?> getFactory() {
      return new PowerFactory<>(ZorrasMod.identifier("prevent_powder_snow_sink"),
      new SerializableData(),
      data ->
              (type, player) -> new PowderSnowSink(type, player))
      .allowCondition();
   }
}
