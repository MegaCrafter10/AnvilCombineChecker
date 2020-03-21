package megacrafter10.combinechecker;

import java.util.Arrays;
import java.util.List;

public class EnchantmentData {

    public static final List<List<String>> groups = Arrays.asList(
            // sword
            Arrays.asList(
                    "DAMAGE_ALL",
                    "DAMAGE_UNDEAD",
                    "DAMAGE_ARTHROPODS",
                    "KNOCKBACK",
                    "FIRE_ASPECT",
                    "LOOT_BONUS_MOBS",
                    "MENDING",
                    "DURABILITY",
                    "VANISHING_CURSE"
            ),
            // bow
            Arrays.asList(
                    "ARROW_DAMAGE",
                    "ARROW_KNOCKBACK",
                    "ARROW_FIRE",
                    "ARROW_INFINITE",
                    "MENDING",
                    "DURABILITY",
                    "VANISHING_CURSE"
            ),
            // chestplate and leggings
            Arrays.asList(
                    "PROTECTION_ENVIRONMENTAL",
                    "PROTECTION_FIRE",
                    "PROTECTION_FALL",
                    "PROTECTION_EXPLOSIONS",
                    "PROTECTION_PROJECTILE",
                    "THORNS",
                    "MENDING",
                    "DURABILITY",
                    "BINDING_CURSE",
                    "VANISHING_CURSE"
            ),
            // helmet
            Arrays.asList(
                    "PROTECTION_ENVIRONMENTAL",
                    "PROTECTION_FIRE",
                    "PROTECTION_FALL",
                    "PROTECTION_EXPLOSIONS",
                    "PROTECTION_PROJECTILE",
                    "THORNS",
                    "MENDING",
                    "DURABILITY",
                    "OXYGEN",
                    "WATER_WORKER",
                    "BINDING_CURSE",
                    "VANISHING_CURSE"
            ),
            // boots
            Arrays.asList(
                    "PROTECTION_ENVIRONMENTAL",
                    "PROTECTION_FIRE",
                    "PROTECTION_FALL",
                    "PROTECTION_EXPLOSIONS",
                    "PROTECTION_PROJECTILE",
                    "THORNS",
                    "MENDING",
                    "DURABILITY",
                    "FROST_WALKER",
                    "DEPTH_STRIDER",
                    "BINDING_CURSE",
                    "VANISHING_CURSE"
            ),
            // tools
            Arrays.asList(
                    "DIG_SPEED",
                    "SILK_TOUCH",
                    "LOOT_BONUS_BLOCKS",
                    "MENDING",
                    "DURABILITY",
                    "VANISHING_CURSE"
            ),
            // fishing rod
            Arrays.asList(
                    "LUCK",
                    "LURE",
                    "MENDING",
                    "DURABILITY",
                    "VANISHING_CURSE"
            )

    );

    public static boolean isCompatible(String ench1, String ench2){
        for (List<String> group : groups){
            if (group.contains(ench1) && group.contains(ench2)) return true;
        }
        return false;
    }
}
