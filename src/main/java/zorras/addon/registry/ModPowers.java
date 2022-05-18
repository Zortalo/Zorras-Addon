package zorras.addon.registry;

import io.github.apace100.apoli.power.*;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import zorras.addon.ZorrasMod;
import zorras.addon.power.*;

public class ModPowers {
   public static final PowerFactory<Power> POWDER_SNOW_SINK = new PowerFactory<>(new Identifier(ZorrasMod.MOD_ID, "prevent_powder_snow_sink"), new SerializableData(), data -> (type, entity) -> new PowderSnowSink(type, entity)).allowCondition();

   public static void init() {
		Registry.register(ApoliRegistries.POWER_FACTORY, POWDER_SNOW_SINK.getSerializerId(), POWDER_SNOW_SINK);
	}
}
