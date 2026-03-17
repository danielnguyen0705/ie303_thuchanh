import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int n = Integer.parseInt(line.trim());
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            points[i] = new Point(x, y);
        }

        ConvexHullFinder finder = new ConvexHullFinder();
        List<Point> result = finder.findHull(points);

        for (Point p : result) {
            System.out.println(p.x + " " + p.y);
        }
    }
}