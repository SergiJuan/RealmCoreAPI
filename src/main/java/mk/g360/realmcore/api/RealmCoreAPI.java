package mk.g360.realmcore.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public interface RealmCoreAPI {
    Realm getRealm(Player player);

    default String getVersion() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("RealmCore");
        return plugin != null ? plugin.getDescription().getVersion() : "unknown";
    }

    static RealmCoreAPI getInstance() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("RealmCore");
        return plugin instanceof RealmCoreProvider ? ((RealmCoreProvider) plugin).getAPI() : null;
    }
}
