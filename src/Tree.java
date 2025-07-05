import java.util.*;
import processing.core.PImage;

public class Tree extends Entity implements Transformable, Animation, Actionable {

    public static final String TREE_KEY = "tree";
    public static final int TREE_HEALTH_MAX = 3;
    public static final int TREE_HEALTH_MIN = 1;

    protected final double animationPeriod;
    protected int health;

    protected final double actionPeriod;
    protected final int healthLimit;

    public int getHealthLimit(){
        return healthLimit;
    }
    public double getActionPeriod() {
        return actionPeriod;
    }

    public Tree(String id, Point position, List<PImage> images, int resourceLimit, int resourceCount, double actionPeriod, double animationPeriod, int health, int healthLimit) {
        super(id, position, images, resourceLimit, resourceCount, actionPeriod, animationPeriod, health, healthLimit);
        this.animationPeriod = animationPeriod;
        this.health = health;
        this.actionPeriod = actionPeriod;
        this.healthLimit = healthLimit;
    }

    public int getHealth() {
        return this.health;
    }

    @Override
    public boolean transformPlant(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        return transformTree(world, scheduler, imageStore);
    }

    public boolean transformTree(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        if (this.getHealth() <= 0) {
            Stump stump = Stump.createStump(STUMP_KEY + '_' + this.getId(), this.getPosition(), imageStore.getImageList(STUMP_KEY));

            world.removeEntity(scheduler, this);
            world.addEntity(stump);

            return true;
        }
        return false;
    }

    @Override
    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        if (!this.transformTree(world, scheduler, imageStore)) {
            scheduler.scheduleEvent(this, Action.createActivityAction(this, world, imageStore), this.getActionPeriod());
        }
    }

    public void healthReduce(){
        this.health--;
    }

    @Override
    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
        scheduler.scheduleEvent(this, Action.createActivityAction(this, world, imageStore), this.getActionPeriod());
        scheduler.scheduleEvent(this, Action.createAnimationAction(this, 0), getAnimationPeriod());
    }

    @Override
    public double getAnimationPeriod() {
        return this.animationPeriod;
    }
}
