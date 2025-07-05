import java.util.List;

public class HospitalArea {

    public static void spawnHospital(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        Point hospitalPosition = new Point(9, 16);
        Hospital hospital = new Hospital("hospital", hospitalPosition, imageStore.getImageList("hospital"),
                1, 1, 0.123, 0.123, 100, 100);
        world.addEntity(hospital);

        List<Point> doctorPositions = List.of(
                new Point(9, 17),
                new Point(8, 17),
                new Point(8, 16),
                new Point(8, 15),
                new Point(9, 15)
        );

        List<Point> whiteTilePositions = List.of(
                new Point(8, 15),
                new Point(9, 15),
                new Point(10, 15),
                new Point(10, 16),
                new Point(10, 17),
                new Point(9, 17),
                new Point(8, 17),
                new Point(8, 16)
        );

        for (Point pos : doctorPositions) {
            Doctor doctor = new Doctor("doctor", pos, imageStore.getImageList("doctor"), 1, 1, 0.23, 0.23, 100, 100);
            world.addEntity(doctor);
            doctor.scheduleActions(scheduler, world, imageStore);
        }

        for (Point position : whiteTilePositions) {
            Tile tile = new Tile("tile", position, imageStore.getImageList("tile"),
                    1, 1, 0.123, 0.123, 100, 100);
            world.addEntity(tile);
        }
    }
}
