import java.util.ArrayList;
import java.util.List;

public class CircusArea {

    public static void spawnCircus(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        List<Point> ferrisWheelPositions = List.of(
                new Point(22, 7),
                new Point(19, 6),
                new Point(22, 5),
                new Point(21, 8)
        );

        List<Point> tentPositions = List.of(
                new Point(23, 7),
                new Point(20, 7),
                new Point(19, 5),
                new Point(20, 5),
                new Point(23, 5),
                new Point(24, 8),
                new Point(25, 8),
                new Point(18, 6),
                new Point(20, 6)
        );

        List<Point> whiteTilePositions = List.of(
                new Point(18, 5),
                new Point(18, 7),
                new Point(19, 7),
                new Point(20, 8),
                new Point(21, 5),
                new Point(21, 6),
                new Point(21, 7),
                new Point(22, 6),
                new Point(22, 8),
                new Point(23, 6),
                new Point(23, 8),
                new Point(24, 7),
                new Point(25, 7)
        );

        for (Point position : ferrisWheelPositions) {
            FerrisWheel ferrisWheel = new FerrisWheel("ferrisWheel", position, imageStore.getImageList("ferrisWheel"), 1, 1, 1.071, 1.071, 100, 100);
            world.addEntity(ferrisWheel);
        }

        for (Point position : tentPositions) {
            Tent tent = new Tent("tent", position, imageStore.getImageList("tent"), 1, 1, 1.071, 1.071, 100, 100);
            world.addEntity(tent);
        }

        for (Point position : whiteTilePositions) {
            Tile tile = new Tile("tile", position, imageStore.getImageList("tile"),
                    1, 1, 0.123, 0.123, 100, 100);
            world.addEntity(tile);
        }
    }

    public static void deleteCircus(WorldModel world, EventScheduler scheduler) {
        List<Point> ferrisWheelPositions = List.of(
                new Point(22, 7),
                new Point(19, 6),
                new Point(22, 5),
                new Point(21, 8)
        );

        List<Point> tentPositions = List.of(
                new Point(23, 7),
                new Point(20, 7),
                new Point(19, 5),
                new Point(20, 5),
                new Point(23, 5),
                new Point(24, 8),
                new Point(25, 8),
                new Point(18, 6),
                new Point(20, 6)
        );

        List<Point> whiteTilePositions = List.of(
                new Point(18, 5),
                new Point(18, 7),
                new Point(19, 7),
                new Point(20, 8),
                new Point(21, 5),
                new Point(21, 6),
                new Point(21, 7),
                new Point(22, 6),
                new Point(22, 8),
                new Point(23, 6),
                new Point(23, 8),
                new Point(24, 7),
                new Point(25, 7)
        );


        List<Point> allCircusPositions = new ArrayList<>();
        allCircusPositions.addAll(ferrisWheelPositions);
        allCircusPositions.addAll(tentPositions);
        allCircusPositions.addAll(whiteTilePositions);

        for (Point position : allCircusPositions) {
            world.getOccupant(position).ifPresent(entity -> world.removeEntity(scheduler, entity));
        }
    }


}