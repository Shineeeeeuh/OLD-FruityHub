package io.shine.fruityhub.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import net.fruity.api.developper.enums.Rank;
import net.fruity.api.developper.manager.PlayerManager;
import net.fruity.api.developper.objects.PlayerProfile;

public class PlayerEvents implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		PlayerProfile pp = PlayerManager.getPlayer(e.getPlayer().getUniqueId().toString());
		if(pp.getRank().getPower() >= Rank.VIP.getPower()){
			e.setJoinMessage(pp.getRank().getPrefix()+" "+e.getPlayer().getName()+" §ea rejoint le Lobby !");
			return;
		}
		e.setJoinMessage("");
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		PlayerProfile pp = PlayerManager.getPlayer(p.getUniqueId().toString());
		e.setFormat(pp.getRank().getPrefix()+" "+p.getName()+" >> "+e.getMessage());
	}

}
