package io.shine.fruityhub.utils;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.*;
import net.minecraft.server.v1_8_R3.*;

public class TitleSender
{
    public void sendTitle(final Player player, final String title, final String subtitle, final int ticks) {
        IChatBaseComponent basetitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
        IChatBaseComponent basesubtitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
        PacketPlayOutTitle titlepacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, basetitle);
        PacketPlayOutTitle subtitlepacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, basesubtitle);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(titlepacket);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(subtitlepacket);
        this.sendTime(player, ticks);
    }
    
    private void sendTime(final Player player, final int ticks) {
        PacketPlayOutTitle titlepacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, 20, ticks, 20);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(titlepacket);
    }
    
    public void sendActionBar(final Player player, final String message) {
        IChatBaseComponent basetitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat packet = new PacketPlayOutChat(basetitle, (byte)2);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
    }
}
