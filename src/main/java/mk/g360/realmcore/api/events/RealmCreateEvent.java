package mk.g360.realmcore.api.events;

import mk.g360.realmcore.api.Realm;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RealmCreateEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Realm realm;

    public RealmCreateEvent(Realm realm) {
        this.realm = realm;
    }

    public Realm getRealm() {
        return realm;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
