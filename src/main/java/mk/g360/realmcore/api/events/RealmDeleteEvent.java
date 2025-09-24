package mk.g360.realmcore.api.events;

import mk.g360.realmcore.api.Realm;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RealmDeleteEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private final Realm realm;

    public RealmDeleteEvent(Realm realm) {
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
