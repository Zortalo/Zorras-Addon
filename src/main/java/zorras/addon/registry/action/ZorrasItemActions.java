package zorras.addon.registry.action;

import io.github.apace100.apoli.power.factory.action.ActionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import zorras.addon.actions.*;

public class ZorrasItemActions {
   public static void register() {
      register(TriggerItemCooldown.getFactory());
   }

   private static void register(ActionFactory<Pair<World, ItemStack>> actionFactory) {
      Registry.register(ApoliRegistries.ITEM_ACTION, actionFactory.getSerializerId(), actionFactory);
   }
}
