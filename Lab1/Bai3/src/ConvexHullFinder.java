import java.util.*;

public class ConvexHullFinder {
    
    // Hàm tính tích chéo để kiểm tra hướng rẽ của 3 điểm (O, A, B)
    // Trả về số dương nếu rẽ trái, âm nếu rẽ phải, 0 nếu thẳng hàng
    private long crossProduct(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    public List<Point> findHull(Point[] points) {
        int n = points.length;
        if (n <= 2) return Arrays.asList(points);

        Arrays.sort(points);
        Point[] hull = new Point[2 * n];
        int k = 0;

        for (int i = 0; i < n; ++i) { //Chuỗi dưới
            while (k >= 2 && crossProduct(hull[k - 2], hull[k - 1], points[i]) <= 0) k--;
            hull[k++] = points[i];
        }

        for (int i = n - 2, t = k + 1; i >= 0; i--) { //Chuỗi trên
            while (k >= t && crossProduct(hull[k - 2], hull[k - 1], points[i]) <= 0) k--;
            hull[k++] = points[i];
        }

        return Arrays.asList(Arrays.copyOfRange(hull, 0, k - 1)); //Loại bỏ điểm trùng
    }
}