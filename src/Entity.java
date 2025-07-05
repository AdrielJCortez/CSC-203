import java.util.*;

import processing.core.PImage;

/**
 * An entity that exists in the world. See EntityKind for the
 * different kinds of entities that exist.
 */
public abstract class Entity {
    /*
        Static variables: These do not need to made private. But you should move them to new classes if appropriate.

        Variables whose names end in "IDX" are indices, i.e., positions. For example, DUDE_NUM_PROPERTIES indicates
        that Dudes have 3 properties (in addition to their id, x position, y position). The DUDE_ACTION_PERIOD_IDX (0)
        indicates that the Dude's action period is its first property, DUDE_ANIMATION_PERIOD_IDX (1) indicates that
        the Dude's animation period is its second property, and so on.
     */
    public static final String STUMP_KEY = "stump";
    public static final int STUMP_NUM_PROPERTIES = 0;

    public static final double SAPLING_ACTION_ANIMATION_PERIOD = 1.000;
    public static final int SAPLING_HEALTH_LIMIT = 5;
    public static final String SAPLING_KEY = "sapling";
    public static final int SAPLING_HEALTH_IDX = 0;
    public static final int SAPLING_NUM_PROPERTIES = 1;

    public static final String OBSTACLE_KEY = "obstacle";
    public static final int OBSTACLE_ANIMATION_PERIOD_IDX = 0;
    public static final int OBSTACLE_NUM_PROPERTIES = 1;

    public static final String FWHEEL_KEY = "ferrisWheel";
    public static final int FWHEEL_ANIMATION_PERIOD_IDX = 0;
    public static final int FWHEEL_NUM_PROPERTIES = 1;

    public static final String TENT_KEY = "tent";
    public static final int TENT_NUM_PROPERTIES = 1;
    public static final int TENT_ANIMATION_PERIOD_IDX = 0;

    public static final String HOSPITAL_KEY = "hospital";
    public static final int HOSPITAL_NUM_PROPERTIES = 1;

    public static final String DOCTOR_KEY = "doctor";
    public static final int DOCTOR_ACTION_PERIOD_IDX = 0;
    public static final int DOCTOR_ANIMATION_PERIOD_IDX = 1;
    public static final int DOCTOR_RESOURCE_LIMIT_IDX = 2;
    public static final int DOCTOR_NUM_PROPERTIES = 3;

    public static final String CLOWN_KEY = "clown";
    public static final int CLOWN_ACTION_PERIOD_IDX = 0;
    public static final int CLOWN_ANIMATION_PERIOD_IDX = 1;
    public static final int CLOWN_RESOURCE_LIMIT_IDX = 2;
    public static final int CLOWN_NUM_PROPERTIES = 3;

    public static final String DUDE_KEY = "dude";
    public static final int DUDE_ACTION_PERIOD_IDX = 0;
    public static final int DUDE_ANIMATION_PERIOD_IDX = 1;
    public static final int DUDE_RESOURCE_LIMIT_IDX = 2;
    public static final int DUDE_NUM_PROPERTIES = 3;

    public static final String HOUSE_KEY = "house";
    public static final int HOUSE_NUM_PROPERTIES = 0;

    public static final String TILE_KEY = "tile";
    public static final int TILE_NUM_PROPERTIES = 0;

    public static final String FAIRY_KEY = "fairy";
    public static final int FAIRY_ANIMATION_PERIOD_IDX = 0;
    public static final int FAIRY_ACTION_PERIOD_IDX = 1;
    public static final int FAIRY_NUM_PROPERTIES = 2;

    public static final String TREE_KEY = "tree";
    public static final int TREE_ANIMATION_PERIOD_IDX = 0;
    public static final int TREE_ACTION_PERIOD_IDX = 1;
    public static final int TREE_HEALTH_IDX = 2;
    public static final int TREE_NUM_PROPERTIES = 3;
    public static final double TREE_ANIMATION_MAX = 0.600;
    public static final double TREE_ANIMATION_MIN = 0.050;
    public static final double TREE_ACTION_MAX = 1.400;
    public static final double TREE_ACTION_MIN = 1.000;
    public static final int TREE_HEALTH_MAX = 3;
    public static final int TREE_HEALTH_MIN = 1;

    // Instance variables
    //private final EntityKind kind;
    // everyone has:
    private final String id;
    private Point position;
    private final List<PImage> images;
    private int imageIndex;
    private double animationPeriod;
    private int health;

    public String getId() {
        return id;
    }
    public Point getPosition() {
        return position;
    }
    public void setPosition(Point position) {
        this.position = position;
    }
    public PImage getCurrentImage(){
        return this.images.get(this.imageIndex % this.images.size());
    }
    public void nextImage() {
        this.imageIndex = this.imageIndex + 1;
    }
    public int getHealth(){
        return this.health;
    }


    public Entity(String id, Point position, List<PImage> images, int resourceLimit,
                  int resourceCount, double actionPeriod, double animationPeriod, int health, int healthLimit) {
        this.id = id;
        this.position = position;
        this.images = images;
        this.imageIndex = 0;
    }

    public static Optional<Entity> nearestEntity(List<Entity> entities, Point pos) {
        if (entities.isEmpty()) {
            return Optional.empty();
        } else {
            Entity nearest = entities.getFirst();
            int nearestDistance = nearest.position.distanceSquared(pos);

            for (Entity other : entities) {
                int otherDistance = other.position.distanceSquared(pos);

                if (otherDistance < nearestDistance) {
                    nearest = other;
                    nearestDistance = otherDistance;
                }
            }

            return Optional.of(nearest);
        }
    }

    /**
     * Helper method for testing. Preserve this functionality while refactoring.
     */
    public String log(){
        return this.id.isEmpty() ? null :
                String.format("%s %d %d %d", this.id, this.position.x, this.position.y, this.imageIndex);
    }

    /**
     * Creates a new House.
     * @param id The new House's id.
     * @param position The new House's position (x,y coordinate) in the World.
     * @param images Images to use for House.
     * @return a new Entity whose type is House.
     */
    public static House createHouse(String id, Point position, List<PImage> images) {
        return new House(id, position, images, 0, 0, 0, 0, 0, 0);
    }

    /**
     * Creates a new Obstacle.
     * @param id The new Obstacle's id.
     * @param position The Obstacle's x,y position in the World.
     * @param animationPeriod The time (seconds) taken for each animation.
     * @param images Images to use for the Obstacle.
     * @return a new Entity whose type is Obstacle.
     */
    public static Obstacle createObstacle(String id, Point position, double animationPeriod, List<PImage> images) {
        return new Obstacle(id, position, images, 0, 0, 0, animationPeriod, 0, 0);
    }

    public static FerrisWheel createFerrisWheel(String id, Point position, double animationPeriod, List<PImage> images) {
        return new FerrisWheel(id, position, images, 0, 0, 0, 0, 0, 0);
    }

    public static Tent createTent(String id, Point position, double animationPeriod, List<PImage> images) {
        return new Tent(id, position, images, 0, 0, 0, 0, 0, 0);
    }

    public static Tree createTree(String id, Point position, double actionPeriod, double animationPeriod, int health, List<PImage> images) {
        return new Tree(id, position, images, 0, 0, actionPeriod, animationPeriod, health, 0);
    }

    public static Stump createStump(String id, Point position, List<PImage> images) {
        return new Stump(id, position, images, 0, 0, 0, 0, 0, 0);
    }

    public static Sapling createSapling(String id, Point position, List<PImage> images, int health) {
        return new Sapling(id, position, images, health);
    }

    public static Fairy createFairy(String id, Point position, double actionPeriod, double animationPeriod, List<PImage> images) {
        return new Fairy(id, position, images, 0, 0, actionPeriod, animationPeriod, 0, 0);
    }

    public static DudeNotFull createDudeNotFull(String id, Point position, double actionPeriod, double animationPeriod, int resourceLimit, List<PImage> images) {
        return new DudeNotFull(id, position, images, resourceLimit, 0, actionPeriod, animationPeriod, 0, 0);
    }

    public static AltDudeNotFull createAltDudeNotFull(String id, Point position, double actionPeriod, double animationPeriod, int resourceLimit, List<PImage> images) {
        return new AltDudeNotFull(id, position, images, resourceLimit, 0, actionPeriod, animationPeriod, 0, 0);
    }

    public static Doctor createDoctor(String id, Point position, double actionPeriod, double animationPeriod, int resourceLimit, List<PImage> images) {
        return new Doctor(id, position, images, resourceLimit, 0, actionPeriod, animationPeriod, 0, 0);
    }

    public static Hospital createHospital(String id, Point position, double actionPeriod, double animationPeriod, int resourceLimit, List<PImage> images) {
        return new Hospital(id, position, images, resourceLimit, 0, actionPeriod, animationPeriod, 0, 0);
    }

    public static Tile createTile(String id, Point position, double actionPeriod, double animationPeriod, int resourceLimit, List<PImage> images) {
        return new Tile(id, position, images, resourceLimit, 0, actionPeriod, animationPeriod, 0, 0);
    }

    public static Clown createClown(String id, Point position, double actionPeriod, double animationPeriod, int resourceLimit, List<PImage> images) {
        return new Clown(id, position, images, resourceLimit, 0, actionPeriod, animationPeriod, 0, 0);
    }

    /**
     * Creates a new DudeFUll
     * @param id The Dude's id.
     *           If a DudeNotFull turns into a DudeFull, it will still have the same id.
     * @param position The Dude's x,y position in the World.
     * @param actionPeriod The time (seconds) taken for each activity (going to the House and turning into a DudeNotFull).
     * @param animationPeriod The time (seconds) taken for each animation.
     * @param resourceLimit The amount of wood this Dude can carry.
     * @param images Images to use for the Dude.
     * @return a new Entity whose type is DudeFull.
     */
    public static DudeFull createDudeFull(String id, Point position, double actionPeriod, double animationPeriod, int resourceLimit, List<PImage> images) {
        return new DudeFull(id, position, images, resourceLimit, 0, actionPeriod, animationPeriod, 0, 0);
    }
}