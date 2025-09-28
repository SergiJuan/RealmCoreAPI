package mk.g360.realmcore.api;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Set;

/** Represents a player's Realm */
public interface Realm {
    String getName();

    Player getOwner();

    Set<Player> getMembers();

    World getWorld();

    World getNetherWorld();

    boolean isMember(Player player);

    boolean isOwner(Player player);

    boolean exists();

    boolean existsNether();
}
