import java.util.*;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import processing.core.PImage;

/**
 * An entity that exists in the world. See EntityKind for the
 * different kinds of entities that exist.
 */
public class DudeFull extends Entity implements Animation,Actionable, Movable {

    protected final List<PImage> images;
    protected final int resourceLimit;
    protected final double animationPeriod;
    protected int health;
    protected final double actionPeriod;
    private PathingStrategy pathingStrategy;


    /**
     * Creates a new Entity.
     *
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
    public DudeFull(String id, Point position, List<PImage> images, int resourceLimit, int resourceCount, double actionPeriod, double animationPeriod, int health, int healthLimit) {
        super(id, position, images, resourceLimit, resourceCount, actionPeriod, animationPeriod, health, healthLimit);
        this.images = images;
        this.resourceLimit= resourceLimit;
        this.animationPeriod= animationPeriod;
        this.actionPeriod = actionPeriod;
        this.pathingStrategy = new AStarPathingStrategy();
    }

    @Override
    public boolean move(WorldModel world, Entity target, EventScheduler scheduler) {
        if (this.getPosition().adjacent(target.getPosition())) {
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
    public Point nextPosition(WorldModel world, Point destPos) {
        Predicate<Point> canPassThrough = pt -> world.withinBounds(pt) && (!world.isOccupied(pt)  || world.getOccupancyCell(pt) instanceof Stump);
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



    public void transformFull(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        Entity dude = createDudeNotFull(this.getId(), this.getPosition(), this.getActionPeriod(), this.animationPeriod, this.resourceLimit, this.images);

        world.removeEntity(scheduler, this);

        world.addEntity(dude);
        ((DudeNotFull) dude).scheduleActions(scheduler, world, imageStore);
    }

    private double getActionPeriod() {
        return this.actionPeriod;
    }

    @Override
    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
        scheduler.scheduleEvent(this, Action.createActivityAction(this, world, imageStore), this.getActionPeriod());
        scheduler.scheduleEvent(this, Action.createAnimationAction(this, 0), getAnimationPeriod());
    }

    @Override
    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        Optional<Entity> fullTarget = world.findNearest(this.getPosition(), List.of(House.class));

        if (fullTarget.isPresent() && this.move(world, fullTarget.get(), scheduler)) {
            this.transformFull(world, scheduler, imageStore);
        } else {
            scheduler.scheduleEvent(this, Action.createActivityAction(this, world, imageStore), this.getActionPeriod());
        }
    }

    @Override
    public double getAnimationPeriod() {
        return this.animationPeriod;
    }

}