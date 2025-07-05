import java.util.*;

import processing.core.PImage;

/**
 * An entity that exists in the world. See EntityKind for the
 * different kinds of entities that exist.
 */
public class Hospital extends Entity{

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
    public Hospital(String id, Point position, List<PImage> images, int resourceLimit, int resourceCount, double actionPeriod, double animationPeriod, int health, int healthLimit) {
        super(id, position, images, resourceLimit, resourceCount, actionPeriod, animationPeriod, health, healthLimit);
    }

}