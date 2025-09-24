package mk.g360.realmcore.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Main API class for RealmCore plugin.
 * Provides access to realms and related operations.
 */
public interface RealmCoreAPI {

    /**
     * Get the Realm of a player.
     * @param player Player object
     * @return Realm instance or null if none
     */
    Realm getRealm(Player player);

    /**
     * Get the version of the API (from plugin.yml).
     * @return RealmCore version string
     */
    default String getVersion() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("RealmCore");
        if (plugin != null) {
            return plugin.getDescription().getVersion();
        }
        return "unknown";
    }
}
