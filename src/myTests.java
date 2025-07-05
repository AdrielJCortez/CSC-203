import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class myTests {

    @Test
    public void test_prof() {
        boolean[][] grid = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        AStarPathingStrategy ps = new AStarPathingStrategy();
        List<Point> path = ps.computePath(
                new Point(0, 0), new Point(2, 2),
                p -> withinBounds(p, grid) && grid[p.y][p.x],
                Point::adjacent, PathingStrategy.CARDINAL_NEIGHBORS
        );
        assertEquals(path.size(),3);
    }

    @Test
    public void test_samestartend() {
        boolean[][] grid = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        Point start = new Point(0, 0);
        Point end = new Point(0, 0);

        AStarPathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start,
                end,
                p -> withinBounds(p, grid) && grid[p.y][p.x],
                Point::equals,
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        assertTrue(path.isEmpty());
    }

    @Test
    public void test_oobe() {
        boolean[][] grid = {
                { false, false, false },
                { false, false, false },
                { false, false, false }
        };
        Point start = new Point(0, 0);
        Point end = new Point(2, 2);

        AStarPathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start,
                end,
                p -> withinBounds(p, grid) && grid[p.y][p.x],
                Point::equals,
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        assertTrue(path.isEmpty());
    }

    @Test
    public void test_alltrue() {
        boolean[][] grid = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        Point start = new Point(0, 0);
        Point end = new Point(2, 2);

        AStarPathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start,
                end,
                p -> withinBounds(p, grid) && grid[p.y][p.x],
                Point::equals,
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        assertEquals(4, path.size());
    }

    @Test
    public void test_hasobstacles() {
        boolean[][] grid = {
                { true, true, true, false },
                { true, false, true, false },
                { true, false, true, true },
                { false, true, true, true }
        };
        Point start = new Point(0, 0);
        Point end = new Point(3, 3);

        AStarPathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start,
                end,
                p -> withinBounds(p, grid) && grid[p.y][p.x],
                (p1, p2) -> p1.equals(p2),
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        assertNotNull(path, "Path should not be null.");
        assertEquals(path.size(), 6);
    }

    @Test
    public void test_only1way() {
        boolean[][] grid = {
                { true, true, false, true },
                { true, false, false, true },
                { true, false, false, true },
                { true, true, true, true }
        };
        Point start = new Point(0, 0);
        Point end = new Point(3, 3);

        AStarPathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start,
                end,
                p -> withinBounds(p, grid) && grid[p.y][p.x],
                Point::equals,
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        assertEquals(path.size(), 6);
    }

    @Test
    public void test_notpossible() {
        boolean[][] grid = {
                { true, false, false, false },
                { false, false, false, false },
                { false, false, false, false },
                { false, false, false, true }
        };
        Point start = new Point(0, 0);
        Point end = new Point(3, 3);

        AStarPathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start,
                end,
                p -> withinBounds(p, grid) && grid[p.y][p.x],
                Point::equals,
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        assertTrue(path.isEmpty());
    }

    @Test
    public void test_timecomplexity() {
        boolean[][] grid = new boolean[1000][1000];
        for (int i = 0; i < 1000; i++) {
            Arrays.fill(grid[i], true);
        }
        Point start = new Point(0, 0);
        Point end = new Point(999, 999);

        AStarPathingStrategy pathingStrategy = new AStarPathingStrategy();
        List<Point> path = pathingStrategy.computePath(
                start,
                end,
                p -> withinBounds(p, grid) && grid[p.y][p.x],
                (p1, p2) -> p1.equals(p2),
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        assertFalse(path.isEmpty());
    }

    private static boolean withinBounds(Point p, boolean[][] grid) {
        return p.y >= 0 && p.y < grid.length &&
                p.x >= 0 && p.x < grid[0].length;
    }
}
