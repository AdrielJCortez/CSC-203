import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import processing.core.PImage;

/**
 * An entity that exists in the world. See EntityKind for the
 * different kinds of entities that exist.
 */
public class Fairy extends Entity implements Animation, Actionable, Movable {

    protected final double animationPeriod;
    protected int health;
    protected final double actionPeriod;
    private PathingStrategy pathingStrategy;

    public double getActionPeriod() {
        return actionPeriod;
    }

    public int getHealth() {
        return this.health;
    }


    /**
     * Creates a new Entity.
     * <p>
     * //@param kind            The kind of entity being created.
     * @param id              The id of the new entity.
     * @param position        The position (x,y coordinate) of this new entity.
     * @param images          The image list associated with this entity.
     * @param resourceLimit   The resourceLimit for this entity. Not all entities need this.
     * @param resourceCount   The resourceCount for this entity. Not all entities need this.
     * @param actionPeriod    The actionPeriod for this entity (i.e., how long it takes to perform each activity action).
     *                        Not all entities need this.
     * @param animationPeriod The animationPeriod (i.e., how long it takes to perform one animation).
     *                        Not all entities need this.
     * @param health          The entity's starting health. Not all entities need this.
     * @param healthLimit     The entity's upper health limit. Not all entities need this.
     */
    public Fairy(String id, Point position, List<PImage> images, int resourceLimit, int resourceCount, double actionPeriod, double animationPeriod, int health, int healthLimit) {
        super(id, position, images, resourceLimit, resourceCount, actionPeriod, animationPeriod, health, healthLimit);
        this.animationPeriod = animationPeriod;
        this.actionPeriod = actionPeriod;
        this.pathingStrategy = new AStarPathingStrategy();
    }

    @Override
    public Point nextPosition(WorldModel world, Point destPos) {
        Predicate<Point> canPassThrough = pt -> world.withinBounds(pt) && !world.isOccupied(pt);
        BiPredicate<Point, Point> withinReach = Point::adjacent;

        List<Point> path = pathingStrategy.computePath(
                this.getPosition(),
                destPos,
                canPassThrough,
                withinReach,
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        return path.isEmpty() ? this.getPosition() : path.getFirst();
    }


    @Override
    public boolean move(WorldModel world, Entity target, EventScheduler scheduler) {
        if (this.getPosition().adjacent(target.getPosition())) {
            world.removeEntity(scheduler, target);
            return true;
        } else {
            Point nextPos = this.nextPosition(world, target.getPosition());

            if (!this.getPosition().equals(nextPos)) {
                world.moveEntity(scheduler, this, nextPos);
            }
            return false;
        }
    }

    @Override
    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
            scheduler.scheduleEvent(this, Action.createActivityAction(this, world, imageStore), this.getActionPeriod());
            scheduler.scheduleEvent(this, Action.createAnimationAction(this, 0), getAnimationPeriod());
    }

    @Override
    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        Optional<Entity> fairyTarget = world.findNearest(this.getPosition(), List.of(Stump.class));

        if (fairyTarget.isPresent() && fairyTarget.get() instanceof Stump stumpTarget) {
            Point tgtPos = stumpTarget.getPosition();

            if (this.move(world, stumpTarget, scheduler)) {
                Sapling sapling = new Sapling(SAPLING_KEY + "_" + stumpTarget.getId(), tgtPos, imageStore.getImageList(SAPLING_KEY), 0);
                world.addEntity(sapling);
                sapling.scheduleActions(scheduler, world, imageStore);
            }
        }

        scheduler.scheduleEvent(this, Action.createActivityAction(this, world, imageStore), this.getActionPeriod());
    }


    @Override
    public double getAnimationPeriod() {
        return this.animationPeriod;
    }
}