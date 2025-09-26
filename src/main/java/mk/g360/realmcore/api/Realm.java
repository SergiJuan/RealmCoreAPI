package mk.g360.realmcore.api;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a player's Realm.
 * The Realm is identified only by its name.
 * Owner and members can be resolved dynamically.
 */
public class Realm {
    private final String name;
    private final String ownerName; // Store owner as a String
    private final Set<String> memberNames; // Store members as names
    private final World world;
    private final World netherWorld;

    /**
     * Creates a Realm instance from its name.
     * Assumes that the owner's name is the same as the realm's name.
     */
    public Realm(String ownerName) {
        this.name = ownerName;
        this.ownerName = name; // Assuming the owner name is the same as realm name
        this.memberNames = new HashSet<>();
        this.memberNames.add(ownerName);

        // Get worlds associated with this realm
        this.world = Bukkit.getWorld("Realms/" + name);
        this.netherWorld = Bukkit.getWorld("Realms_Nether/" + name);
    }

    public String getName() {
        return name;
    }

    /** Returns the owner as Player if online, null otherwise */
    public Player getOwner() {
        return Bukkit.getPlayer(ownerName);
    }

    /** Returns all members as Player objects who are currently online */
    public Set<Player> getMembers() {
        Set<Player> members = new HashSet<>();
        for (String memberName : memberNames) {
            Player player = Bukkit.getPlayer(memberName);
            if (player != null) members.add(player);
        }
        return Collections.unmodifiableSet(members);
    }

    /** Returns the raw world object */
    public World getWorld() {
        return world;
    }

    /** Returns the raw nether world object */
    public World getNetherWorld() {
        return netherWorld;
    }

    /** Adds a member to the realm */
    public boolean addMember(Player player) {
        return memberNames.add(player.getName());
    }

    /** Removes a member from the realm */
    public boolean removeMember(Player player) {
        return memberNames.remove(player.getName());
    }

    /** Checks if a player is a member */
    public boolean isMember(Player player) {
        return memberNames.contains(player.getName());
    }

    /** Checks if a player is the owner */
    public boolean isOwner(Player player) {
        return ownerName.equals(player.getName());
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
