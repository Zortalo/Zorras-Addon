package zorras.addon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import zorras.addon.registry.*;
import zorras.addon.registry.action.*;
import zorras.addon.registry.condition.*;

public class ZorrasMod implements ModInitializer {
	public static final String MOD_ID = "zorras";
	public static final Logger LOGGER = LogManager.getLogger(ZorrasMod.class);

	public static Identifier identifier(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		// Log
		LOGGER.info("Zorras Addon is active. Enjoy the show!");

		// Origin Registry
		ZorrasPowerFactory.register();
		ZorrasItemActions.register();
		ZorrasEntityConditions.register();
	}
}
