package io.shine.fruityhub.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import io.shine.fruityhub.utils.Skull;
import io.shine.fruityhub.utils.TitleSender;
import net.fruity.api.developper.manager.PlayerManager;
import net.fruity.api.developper.objects.PlayerProfile;
import net.fruity.api.spigot.builder.ItemBuilder;
import net.fruity.api.spigot.builder.ScoreboardSign;

public class HubEvents implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.teleport(new Location(Bukkit.getWorld("world"), 116.5, 70, -115.5, 180F,5F));
		TitleSender title = new TitleSender();
		title.sendTitle(p, "§e< §6Fruity §e>", "§eBievenu(e) !", 20);
		loadSB(p);
		loadInventory(p);
	}
	
	public void loadSB(Player p) {
		PlayerProfile pp = PlayerManager.getPlayer(p.getUniqueId().toString());
		ScoreboardSign sbs = new ScoreboardSign(p, "§d✵ §eFruity §d✵");
		sbs.create();
		sbs.setLine(1, "§a");
		sbs.setLine(2, "§7✎ §b§l"+p.getName());
		sbs.setLine(3, "§7➼ §l"+pp.getRank().getPrefix());
		sbs.setLine(4, "§d");
		sbs.setLine(5, "§7➼ §6§l"+pp.getCoins()+" §c§l♦");
		sbs.setLine(6, "§e");
		sbs.setLine(7, "§7➼ §a§lHub1");
		sbs.setLine(8, "§9");
		sbs.setLine(9, "§6§l✵ §e§lplay.fruity-network.fr §6§l✵");
	}
	
	public void loadInventory(Player p) {
		p.getInventory().clear();
		p.getInventory().setItem(0, new ItemBuilder(Skull.getPlayerSkull(p.getName())).setName("§cProfil").build());
		p.getInventory().setItem(4, new ItemBuilder(Material.NETHER_STAR).setName("§dJeux").build());
		p.getInventory().setItem(8, new ItemBuilder(Material.GOLD_INGOT).setName("§6Boutique").build());
	}
	

}
