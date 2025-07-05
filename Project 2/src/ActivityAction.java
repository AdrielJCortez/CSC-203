public class ActivityAction extends Action {
    private final WorldModel world;
    private final ImageStore imageStore;

    public ActivityAction(Entity entity, WorldModel world, ImageStore imageStore, int repeatCount) {
        super(entity, repeatCount);
        this.world = world;
        this.imageStore = imageStore;
    }

    @Override
    public void executeAction(EventScheduler scheduler) {
//        if (this.entity instanceof Actionable){
//            this.getClass().executeActivity();
//        }
        switch (this.entity) {
            case Sapling sapling -> sapling.executeActivity(this.world, this.imageStore, scheduler);
            case Tree tree -> tree.executeActivity(this.world, this.imageStore, scheduler);
            case Fairy fairy -> fairy.executeActivity(this.world, this.imageStore, scheduler);
            case DudeNotFull dudeNotFull -> dudeNotFull.executeActivity(this.world, this.imageStore, scheduler);
            case DudeFull dudeFull -> dudeFull.executeActivity(this.world, this.imageStore, scheduler);
            case Doctor doctor -> doctor.executeActivity(this.world, this.imageStore, scheduler);
            case Clown clown -> clown.executeActivity(this.world, this.imageStore, scheduler);
            case AltDudeNotFull altDudeNotFull -> altDudeNotFull.executeActivity(this.world, this.imageStore, scheduler);
            default ->
                    throw new UnsupportedOperationException("executeActivityAction not supported for this entity type");
        }
    }
}
