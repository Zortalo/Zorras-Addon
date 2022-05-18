package zorras.addon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import zorras.addon.item.*;
import zorras.addon.registry.*;

public class ZorrasMod implements ModInitializer {
	public static final String MOD_ID = "zorras";
	public static final Logger LOGGER = LogManager.getLogger(ZorrasMod.class);
	public static String VERSION = "";
//Origins Nonsense

	@Override
	public void onInitialize() {
		FabricLoader.getInstance().getModContainer(MOD_ID).ifPresent(modContainer -> {
			VERSION = modContainer.getMetadata().getVersion().getFriendlyString();
			if(VERSION.contains("+")) {
				VERSION = VERSION.split("\\+")[0];
			}
			if(VERSION.contains("-")) {
				VERSION = VERSION.split("-")[0];
			}
		});
		LOGGER.info("Zorras Addon " + VERSION + " is active. Enjoy the show!");
		//Origin Registry
		ModPowers.init();
		//Item Registery
		WyrmString.registerItems();
      DinoNugget.registerItems();
		GoldenDinoNugget.registerItems();
	}
	public static void init() {
		
	}
}
