import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import processing.core.PImage;

public class DudeNotFull extends Entity implements Animation, Actionable, Movable{

    protected final List<PImage> images;
    protected final int resourceLimit;
    protected final double animationPeriod;
    protected double resourceCount;
    protected int health;
    protected final double actionPeriod;
    protected final int healthLimit;
    protected PathingStrategy pathingStrategy;

    public int getHealth() {
        return this.health;
    }

    public double getActionPeriod() {
        return actionPeriod;
    }

    public DudeNotFull(String id, Point position, List<PImage> images, int resourceLimit, int resourceCount, double actionPeriod, double animationPeriod, int health, int healthLimit) {
        super(id, position, images, resourceLimit, resourceCount, actionPeriod, animationPeriod, health, healthLimit);
        this.images = images;
        this.resourceLimit = resourceLimit;
        this.animationPeriod= animationPeriod;
        this.resourceCount = resourceCount;
        this.health = health;
        this.actionPeriod = actionPeriod;
        this.healthLimit = healthLimit;
        this.pathingStrategy = new AStarPathingStrategy();
    }

    @Override
    public Point nextPosition(WorldModel world, Point destPos) {
        Predicate<Point> canPassThrough = pt -> world.withinBounds(pt) && (!world.isOccupied(pt)  || world.getOccupancyCell(pt) instanceof Stump);
        BiPredicate<Point, Point> withinReach = Point::adjacent;

        List<Point> path = pathingStrategy.computePath(this.getPosition(), destPos, canPassThrough, withinReach, PathingStrategy.CARDINAL_NEIGHBORS);

        return path.isEmpty() ? this.getPosition() : path.get(0);
    }



    @Override
    public boolean move(WorldModel world, Entity target, EventScheduler scheduler) {
        if (this.getPosition().adjacent(target.getPosition())) {
            if (target instanceof Tree tree){
                this.resourceCount += 1;
                tree.healthReduce();
                return true;
            } else if (target instanceof Sapling sapling){
                this.resourceCount += 1;
                sapling.healthReduce();
                return true;
            } else if (target instanceof Tent) {
                return true;
            }
        } else {
            Point nextPos = this.nextPosition(world, target.getPosition());

            if (!this.getPosition().equals(nextPos)) {
                world.moveEntity(scheduler, this, nextPos);
            }
            return false;
        }
        return false;
    }

    public boolean transformNotFull(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        if (this.resourceCount >= this.resourceLimit) {
            DudeFull dudeFull = new DudeFull(
                    this.getId(), this.getPosition(),
                    this.images, this.resourceLimit, (int) this.resourceCount,
                    this.getActionPeriod(), this.getAnimationPeriod(),
                    this.getHealth(), this.getHealthLimit()
            );

            world.removeEntity(scheduler, this);
            scheduler.unscheduleAllEvents(this);

            world.addEntity(dudeFull);
            dudeFull.scheduleActions(scheduler, world, imageStore);

            return true;
        }



        return false;
    }

    public boolean transformToClown(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        Clown clown = new Clown(this.getId(), this.getPosition(), imageStore.getImageList("clown"), resourceLimit, 0,
                0.47, 0.47, 0, 0);

        world.removeEntity(scheduler, this);
        scheduler.unscheduleAllEvents(this);

        world.addEntity(clown);
        clown.scheduleActions(scheduler, world, imageStore);

        return true;
    }


    private int getHealthLimit() {
        return this.healthLimit;
    }

    @Override
    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
            scheduler.scheduleEvent(this, Action.createActivityAction(this, world, imageStore), this.getActionPeriod());
            scheduler.scheduleEvent(this, Action.createAnimationAction(this, 0), getAnimationPeriod());
    }

    @Override
    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        Optional<Entity> target1 = world.findNearest(this.getPosition(), List.of(Tent.class, FerrisWheel.class));
        Optional<Entity> target2 = world.findNearest(this.getPosition(), List.of(Tree.class, Sapling.class));
        if (target1.isPresent() && target1.get() instanceof Tent) {
            this.transformToClown(world, scheduler, imageStore);
        } else if (target2.isEmpty() || !this.move(world, target2.get(), scheduler) || !this.transformNotFull(world, scheduler, imageStore)) {
            scheduler.scheduleEvent(this, Action.createActivityAction(this, world, imageStore), this.getActionPeriod());
        }
    }

//    @Override
//    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
//        Optional<Entity> target = world.findNearest(this.getPosition(), List.of(Tree.class, Sapling.class, Tent.class));
//        if (target.isPresent() && target.get() instanceof Tent) {
//            this.transformToClown(world, scheduler, imageStore);
//        } else if (target.isEmpty() || !this.move(world, target.get(), scheduler) || !this.transformNotFull(world, scheduler, imageStore)) {
//            scheduler.scheduleEvent(this, Action.createActivityAction(this, world, imageStore), this.getActionPeriod());
//        }
//    }



    @Override
    public double getAnimationPeriod() {
        return this.animationPeriod;
    }
}