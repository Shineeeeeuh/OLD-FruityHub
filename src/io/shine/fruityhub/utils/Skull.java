package io.shine.fruityhub.utils;

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;

public enum Skull
{
    ARROW_LEFT("ARROW_LEFT", 0, "MHF_ArrowLeft"), 
    ARROW_RIGHT("ARROW_RIGHT", 1, "MHF_ArrowRight"), 
    ARROW_UP("ARROW_UP", 2, "MHF_ArrowUp"), 
    ARROW_DOWN("ARROW_DOWN", 3, "MHF_ArrowDown"), 
    QUESTION("QUESTION", 4, "MHF_Question"), 
    EXCLAMATION("EXCLAMATION", 5, "MHF_Exclamation"), 
    CAMERA("CAMERA", 6, "FHG_Cam"), 
    ZOMBIE_PIGMAN("ZOMBIE_PIGMAN", 7, "MHF_PigZombie"), 
    PIG("PIG", 8, "MHF_Pig"), 
    SHEEP("SHEEP", 9, "MHF_Sheep"), 
    BLAZE("BLAZE", 10, "MHF_Blaze"), 
    CHICKEN("CHICKEN", 11, "MHF_Chicken"), 
    COW("COW", 12, "MHF_Cow"), 
    SLIME("SLIME", 13, "MHF_Slime"), 
    SPIDER("SPIDER", 14, "MHF_Spider"), 
    SQUID("SQUID", 15, "MHF_Squid"), 
    VILLAGER("VILLAGER", 16, "MHF_Villager"), 
    OCELOT("OCELOT", 17, "MHF_Ocelot"), 
    HEROBRINE("HEROBRINE", 18, "MHF_Herobrine"), 
    LAVA_SLIME("LAVA_SLIME", 19, "MHF_LavaSlime"), 
    MOOSHROOM("MOOSHROOM", 20, "MHF_MushroomCow"), 
    GOLEM("GOLEM", 21, "MHF_Golem"), 
    GHAST("GHAST", 22, "MHF_Ghast"), 
    ENDERMAN("ENDERMAN", 23, "MHF_Enderman"), 
    CAVE_SPIDER("CAVE_SPIDER", 24, "MHF_CaveSpider"), 
    CACTUS("CACTUS", 25, "MHF_Cactus"), 
    CAKE("CAKE", 26, "MHF_Cake"), 
    CHEST("CHEST", 27, "MHF_Chest"), 
    MELON("MELON", 28, "MHF_Melon"), 
    LOG("LOG", 29, "MHF_OakLog"), 
    PUMPKIN("PUMPKIN", 30, "MHF_Pumpkin"), 
    TNT("TNT", 31, "MHF_TNT"), 
    DYNAMITE("DYNAMITE", 32, "MHF_TNT2");
    
    private static final Base64 base64;
    private String id;
    
    static {
        base64 = new Base64();
    }
    
    private Skull(final String s, final int n, final String id) {
        this.id = id;
    }
    
    public static ItemStack getCustomSkull(String url) {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        if (propertyMap == null) {
            throw new IllegalStateException("Profile doesn't contain a property map");
        }
        byte[] encodedData = base64.encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        propertyMap.put("textures", new Property("textures", new String(encodedData)));
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ItemMeta headMeta = head.getItemMeta();
        Class<?> headMetaClass = headMeta.getClass();
        Reflections.getField(headMetaClass, "profile", GameProfile.class).set(headMeta, profile);
        head.setItemMeta(headMeta);
        return head;
    }
    public static ItemStack getPlayerSkull(String name) {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setOwner(name);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public String getId() {
        return id;
    }

    public ItemStack getSkull() {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta meta = (SkullMeta) itemStack.getItemMeta();
        meta.setOwner(id);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

}