package zorras.addon.actions;

import io.github.apace100.apoli.power.factory.action.ActionFactory;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import net.minecraft.world.World;
import zorras.addon.ZorrasMod;

public class TriggerItemCooldown {
   public static void action(SerializableData.Instance data, Pair<World, ItemStack> worldAndStack) {
      if (worldAndStack.getLeft().isClient()) {
         return;
      }

      LivingEntity stackHolder = (LivingEntity) ((ItemStackAccess) (Object) worldAndStack.getRight()).getEntity();

      int duration = data.getInt("duration");

      if (stackHolder != null) {
         ((PlayerEntity) stackHolder).getItemCooldownManager().set(worldAndStack.getRight().getItem(), duration);
      }
   }

   public static ActionFactory<Pair<World, ItemStack>> getFactory() {
      return new ActionFactory<>(ZorrasMod.identifier("trigger_item_cooldown"),
            new SerializableData()
                  .add("duration", SerializableDataTypes.INT, 20),
            TriggerItemCooldown::action);
   }
   
}
