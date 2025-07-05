public class PathNode {
    Point point;
    PathNode previous;
    double g;
    double f;

    public PathNode(Point point, PathNode previous, double g, double f) {
        this.point = point;
        this.previous = previous;
        this.g = g;
        this.f = f;
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        if (this.point == ((PathNode) o).point) return true;
        return false;
    }

}