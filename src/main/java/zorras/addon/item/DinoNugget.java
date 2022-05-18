package zorras.addon.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import zorras.addon.ZorrasMod;

public class DinoNugget {
   public static final Item DINO_NUGGY = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(1).saturationModifier(0f).snack().meat().alwaysEdible().build()));

   public static void registerItems() {
      Registry.register(Registry.ITEM, new Identifier(ZorrasMod.MOD_ID, "dino_nuggy"), DINO_NUGGY);
   }
}