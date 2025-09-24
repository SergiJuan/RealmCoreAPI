package mk.g360.realmcore.api;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a player's Realm.
 */
public class Realm {
    private final String name;
    private final Player owner;
    private final Set<Player> members;
    private final World world;
    private final World netherWorld;

    public Realm(String name, Player owner) {
        this.name = name;
        this.owner = owner;
        this.members = new HashSet<>();
        this.members.add(owner); // Owner is automatically a member

        // Obtener los mundos asociados
        this.world = Bukkit.getWorld("Realms/" + name);
        this.netherWorld = Bukkit.getWorld("Realms_Nether/" + name);
    }

    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }

    public World getWorld() {
        return world;
    }

    public World getNetherWorld() {
        return netherWorld;
    }

    public Set<Player> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    /** Adds a member to the Realm */
    public boolean addMember(Player player) {
        return members.add(player);
    }

    /** Removes a member from the Realm */
    public boolean removeMember(Player player) {
        return members.remove(player);
    }

    /** Checks if a player is a member */
    public boolean isMember(Player player) {
        return members.contains(player);
    }

    /** Checks if a player is the owner */
    public boolean isOwner(Player player) {
        return owner.equals(player);
    }

    /** Check if realm world exists */
    public boolean exists() {
        return world != null;
    }

    /** Check if realm nether world exists */
    public boolean existsNether() {
        return netherWorld != null;
    }
}