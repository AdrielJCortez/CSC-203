import java.util.*;
import processing.core.PImage;

/**
 * A Sapling entity that grows over time and has a health limit.
 */
public class Sapling extends Entity implements Transformable, Animation, Actionable {

    public static final double ACTION_ANIMATION_PERIOD = 1.000;
    public static final int HEALTH_LIMIT = 5;

    private int health;
    protected double animationPeriod;

    protected final double actionPeriod;
    protected final int healthLimit;

    public double getActionPeriod() {
        return ACTION_ANIMATION_PERIOD;
    }

    /**
     * Creates a new Sapling with specified parameters.
     *
     * @param id The id of the Sapling.
     * @param position The position of the Sapling in the world.
     * @param images The image list for the Sapling.
     * @param health The initial health of the Sapling.
     */
    public Sapling(String id, Point position, List<PImage> images, int health) {
        super(id, position, images, 0, 0, ACTION_ANIMATION_PERIOD, ACTION_ANIMATION_PERIOD, health, HEALTH_LIMIT);
        this.health = health;
        this.animationPeriod = ACTION_ANIMATION_PERIOD;
        this.actionPeriod = ACTION_ANIMATION_PERIOD;
        this.healthLimit = HEALTH_LIMIT;
    }

    public int getHealth() {
        return this.health;
    }

    public int getHealthLimit() {
        return HEALTH_LIMIT;
    }
    public void healthReduce(){
        this.health--;
    }

    @Override
    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        this.health++;
        if (!this.transformPlant(world, scheduler, imageStore)) {
            scheduler.scheduleEvent(this, Action.createActivityAction(this, world, imageStore), this.getActionPeriod());
        }
    }

    @Override
    public boolean transformPlant(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        return transformSapling(world, scheduler, imageStore);
    }

    public boolean transformSapling(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        if (this.getHealth() <= 0) {
            Stump stump = Stump.createStump("stump_"+this.getId(), this.getPosition(), imageStore.getImageList(STUMP_KEY));
            world.removeEntity(scheduler, this);
            world.addEntity(stump);
            return true;
        } else if (this.getHealth() >= HEALTH_LIMIT) {
            Tree tree = Tree.createTree(
                    TREE_KEY + "_" + this.getId(),
                    this.getPosition(),
                    Functions.getNumFromRange(Tree.TREE_ACTION_MAX, Tree.TREE_ACTION_MIN),
                    Functions.getNumFromRange(Tree.TREE_ANIMATION_MAX, Tree.TREE_ANIMATION_MIN),
                    Functions.getIntFromRange(Tree.TREE_HEALTH_MAX, Tree.TREE_HEALTH_MIN),
                    imageStore.getImageList(TREE_KEY)
            );
            world.removeEntity(scheduler, this);
            world.addEntity(tree);
            tree.scheduleActions(scheduler, world, imageStore);
            return true;
        }
        return false;
    }

    @Override
    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
        scheduler.scheduleEvent(this, Action.createActivityAction(this, world, imageStore), this.getActionPeriod());
        scheduler.scheduleEvent(this, Action.createAnimationAction(this, 0), getAnimationPeriod());
    }

    @Override
    public double getAnimationPeriod() {
        return ACTION_ANIMATION_PERIOD;
    }
}