package zorras.addon.registry;

import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.util.registry.Registry;
import zorras.addon.power.*;

public class ZorrasPowerFactory {

   public static void register(){
      register(ModifyPowderSnow.getFactory());
  }


  public static void register(PowerFactory<?> serializer) {
      Registry.register(ApoliRegistries.POWER_FACTORY, serializer.getSerializerId(), serializer);
   }
}
