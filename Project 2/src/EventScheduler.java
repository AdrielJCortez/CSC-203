import java.util.*;

/**
 * Keeps track of events that have been scheduled.
 */
public final class EventScheduler {
    private final PriorityQueue<Event> eventQueue;
    private final Map<Entity, List<Event>> pendingEvents;
    private double currentTime;

    public EventScheduler() {
        this.eventQueue = new PriorityQueue<>((event1, event2) -> (int) (1000 * (event1.getTime() - event2.getTime())));
        this.pendingEvents = new HashMap<>();
        this.currentTime = 0;
    }

    public double getCurrentTime() {
        return this.currentTime;
    }

    public void updateOnTime(double time) {
        double stopTime = this.currentTime + time;
        while (!this.eventQueue.isEmpty() && this.eventQueue.peek().getTime() <= stopTime) {
            Event next = this.eventQueue.poll();
            removePendingEvent(next);
            this.currentTime = next.getTime();
            next.getAction().executeAction(this);
        }
        this.currentTime = stopTime;
    }

    public void removePendingEvent(Event event) {
        List<Event> pending = this.pendingEvents.get(event.getEntity());

        if (pending != null) {
            pending.remove(event);
        }
    }

    public void unscheduleAllEvents(Entity entity) {
        List<Event> pending = this.pendingEvents.remove(entity);

        if (pending != null) {
            for (Event event : pending) {
                this.eventQueue.remove(event);
            }
        }
    }

    public void scheduleEvent(Entity entity, Action action, double afterPeriod) {
        double time = this.currentTime + afterPeriod;

        Event event = new Event(action, time, entity);

        this.eventQueue.add(event);

        // update list of pending events for the given entity
        List<Event> pending = this.pendingEvents.getOrDefault(entity, new LinkedList<>());
        pending.add(event);
        this.pendingEvents.put(entity, pending);
    }
}
