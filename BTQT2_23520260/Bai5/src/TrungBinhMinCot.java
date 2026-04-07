public class TrungBinhMinCot {
    public void giai(double[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        double sumMin = 0;
        for (int j = 0; j < cols; j++) {
            double min = M[0][j];
            for (int i = 1; i < rows; i++) {
                if (M[i][j] < min) min = M[i][j];
            }
            sumMin += min;
        }
        System.out.println("b. Trung bình cộng các phần tử nhỏ nhất mỗi cột: " + (sumMin / cols));
    }
}