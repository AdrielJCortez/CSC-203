public abstract class Action {
    protected final Entity entity;
    protected final int repeatCount;
    // hi

    public Action(Entity entity, int repeatCount) {
        this.entity = entity;
        this.repeatCount = repeatCount;
    }

    public abstract void executeAction(EventScheduler scheduler);

    public static Action createActivityAction(Entity entity, WorldModel world, ImageStore imageStore) {
        return new ActivityAction(entity, world, imageStore, 0);
    }

    public static Action createAnimationAction(Entity entity, int repeatCount) {
        return new AnimationAction(entity, repeatCount);
    }
}
