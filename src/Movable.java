public interface Movable {
    Point nextPosition(WorldModel world, Point destPos);
    boolean move(WorldModel world, Entity target, EventScheduler scheduler);
}
