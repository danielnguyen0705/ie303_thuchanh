public class Point implements Comparable<Point> {
    long x, y; 

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    // Sắp xếp theo x tăng dần, nếu x bằng nhau thì sắp xếp theo y tăng dần
    @Override
    public int compareTo(Point other) {
        if (this.x != other.x) return Long.compare(this.x, other.x);
        return Long.compare(this.y, other.y);
    }
}