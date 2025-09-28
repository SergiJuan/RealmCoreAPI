package mk.g360.realmcore.api;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;

/** Represents a player's Realm */
public interface Realm {
    String getName();

    Player getOwner();

    List<String> getTrusted();

    World getWorld();

    World getNetherWorld();

    boolean isTrusted(String playerName);

    boolean isOwner(String playerName);

    boolean exists();

    boolean existsNether();
}
