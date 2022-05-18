package zorras.addon.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import zorras.addon.ZorrasMod;

public class WyrmString {
   public static final Item WYRM_STRING =new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC));

   public static void registerItems() {
      Registry.register(Registry.ITEM, new Identifier(ZorrasMod.MOD_ID, "wyrm_string"), WYRM_STRING);
   }
}