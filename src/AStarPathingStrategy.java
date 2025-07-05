import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AStarPathingStrategy implements PathingStrategy {

    @Override
    public List<Point> computePath(
            Point start, //S
            Point goal, //G
            Predicate<Point> canPassThrough,
            BiPredicate<Point, Point> withinReach,
            Function<Point, Stream<Point>> potentialNeighbors) {

        // to be eval
        PriorityQueue<PathNode> openNodesPQ = new PriorityQueue<>(Comparator.comparingDouble(n -> n.f));

        // done w eval
        Set<Point> doneSet = new HashSet<>();

        // S
        double h = manhattanDistance(start, goal);
        //Node(pos, prev, g, f)
        PathNode startNode = new PathNode(start, null, 0, h);
        // bcs it's the starting node, so f = h
        openNodesPQ.add(startNode);

        while (!openNodesPQ.isEmpty()) {
            PathNode current = openNodesPQ.poll();

            // in done = skip
            if (doneSet.contains(current.point)) {
                continue;
            }
            // next to you = reached
            if (withinReach.test(current.point, goal)) {
                openNodesPQ.remove(current);
                return Path(current);
            }
            doneSet.add(current.point);

            // make neighbors
            List<Point> neighbors = potentialNeighbors.apply(current.point)
                    .filter(canPassThrough)
                    .toList();
            for (Point neighbor : neighbors) {
                if (doneSet.contains(neighbor)) {
                    continue;
                }
                double g = current.g + 1;
                h = manhattanDistance(neighbor, goal);
                double f = g + h;

                PathNode neighborNode = new PathNode(neighbor, current, g, f);

                if (!openNodesPQ.contains(neighborNode)){
                    openNodesPQ.add(neighborNode);
                }
            }
        }
        // no path
        return Collections.emptyList();
    }

    private double manhattanDistance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private List<Point> Path(PathNode current) {
        List<Point> path = new LinkedList<>();
        while (current.previous != null && current.previous.point != null) {
            path.addFirst(current.point);
            current = current.previous;
        }
        return path;
    }
}