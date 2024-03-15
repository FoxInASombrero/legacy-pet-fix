package hu.szviktor.plugins.petfix;

import org.bukkit.plugin.java.JavaPlugin;

import hu.szviktor.plugins.petfix.listeners.EntityListener;

public class PluginBootstrap extends JavaPlugin {

	/**
	 * Az alábbi Plugin egy, a korai Minecraft verziókban megtalálható hibát(?!)
	 * igyekszik javítani, mikor is, a kisállatok (farkas és macska) ülve is a
	 * játékos után teleportálnak.
	 * 
	 * A hiba 1.0-tól 1.6.4-ig lelhető fel, az 1.7-es csomagban javításra kerül.
	 */

	@Override
	public void onEnable() {
		this.getLogger().info("A Plugin betöltése folyamatban van...");

		this.getServer().getPluginManager().registerEvents(new EntityListener(), this);

		this.getLogger().info("A Plugin betöltése kész!");
	}

	@Override
	public void onDisable() {
		this.getLogger().info("A Plugin sikeresen leállt!");
	}

}
