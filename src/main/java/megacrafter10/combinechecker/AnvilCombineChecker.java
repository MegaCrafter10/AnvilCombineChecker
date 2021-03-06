package megacrafter10.combinechecker;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class AnvilCombineChecker extends JavaPlugin implements Listener {

    private final Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        logger.info(getDescription().getName() + " enabled");
        this.getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        logger.info(getDescription().getName() + " disabled");
    }

    @EventHandler
    public void onEnchantmentCombine(PrepareAnvilEvent event) {
        if (event.getInventory().getType() == InventoryType.ANVIL) {
            ItemStack item1 = event.getInventory().getItem(0);
            ItemStack item2 = event.getInventory().getItem(1);
            if (item1 == null || item2 == null) {
                return;
            }
            if (item1.getType() == Material.ENCHANTED_BOOK && item2.getType() == Material.ENCHANTED_BOOK) {
                EnchantmentStorageMeta enchMeta1 = (EnchantmentStorageMeta) item1.getItemMeta();
                EnchantmentStorageMeta enchMeta2 = (EnchantmentStorageMeta) item2.getItemMeta();
                for (Enchantment ench : enchMeta1.getStoredEnchants().keySet()) {
                    for (Enchantment ench2 : enchMeta2.getStoredEnchants().keySet()) {
                        if (!EnchantmentData.isCompatible(ench.getName(), ench2.getName())) {
                            event.setResult(new ItemStack(Material.AIR));
                            return;
                        }
                    }
                }
            }
        }
    }

    /* this handler displays the result and displays an error message
    @EventHandler
    public void onEnchantmentCombine(InventoryClickEvent event){
        if (event.getInventory().getType() == InventoryType.ANVIL){
            if (event.getRawSlot() == 2){
                ItemStack item1 = event.getInventory().getItem(0);
                ItemStack item2 = event.getInventory().getItem(1);
                if (item1 == null || item2 == null){
                    return;
                }
                if (item1.getType() == Material.ENCHANTED_BOOK && item2.getType() == Material.ENCHANTED_BOOK){
                    EnchantmentStorageMeta enchMeta1 = (EnchantmentStorageMeta) item1.getItemMeta();
                    EnchantmentStorageMeta enchMeta2 = (EnchantmentStorageMeta) item2.getItemMeta();
                    for (Enchantment ench : enchMeta1.getStoredEnchants().keySet()){
                        for (Enchantment ench2 : enchMeta2.getStoredEnchants().keySet()){
                            if (!EnchantmentData.isCompatible(ench.getName(),ench2.getName())){
                                event.setCancelled(true);
                                event.getWhoClicked().sendMessage(ChatColor.RED +
                                        "Enchantments are not compatible");
                                return;
                            }
                        }
                    }
                }
            }
        }
    }*/
}
