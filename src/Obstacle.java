import java.util.*;

import processing.core.PImage;

public class Obstacle extends Entity implements Animation, Actionable {

    protected final double animationPeriod;

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
    public Obstacle(String id, Point position, List<PImage> images, int resourceLimit, int resourceCount, double actionPeriod, double animationPeriod, int health, int healthLimit) {
        super(id, position, images, resourceLimit, resourceCount, actionPeriod, animationPeriod, health, healthLimit);
        this.animationPeriod = animationPeriod;
    }

    @Override
    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
        scheduler.scheduleEvent(this, Action.createAnimationAction(this, 0), getAnimationPeriod());
    }

    @Override
    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {}


//    public static Obstacle CreateObstacle(String id, Point position, double animationPeriod, List<PImage> images) {
//        return new Obstacle(EntityKind.OBSTACLE, id, position, images, 0, 0, 0, animationPeriod, 0, 0);
//    }

    @Override
    public double getAnimationPeriod() {
        return this.animationPeriod;
    }

}