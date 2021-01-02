package io.shine.fruityhub;

import org.bukkit.plugin.java.JavaPlugin;

import io.shine.fruityhub.events.HubEvents;
import io.shine.fruityhub.events.PlayerEvents;
import io.shine.fruityhub.events.ProtectionEvents;

public class FruityHub extends JavaPlugin{
	@Override
	public void onEnable() {
		registerEvents();
	}
	
	public void registerEvents() {
		getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
		getServer().getPluginManager().registerEvents(new ProtectionEvents(), this);
		getServer().getPluginManager().registerEvents(new HubEvents(), this);
	}
}
