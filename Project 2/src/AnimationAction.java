public class AnimationAction extends Action {

    public AnimationAction(Entity entity, int repeatCount) {
        super(entity, repeatCount);
    }

    @Override
    public void executeAction(EventScheduler scheduler) {
        this.entity.nextImage();

        if (this.repeatCount != 1 && this.entity instanceof Animation animatedEntity) {
            scheduler.scheduleEvent(
                    this.entity,
                    createAnimationAction(this.entity, Math.max(this.repeatCount - 1, 0)),
                    animatedEntity.getAnimationPeriod()
            );
        }
    }
}
