public class XoaDongTongMax {
    public double[][] giai(double[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        if (rows <= 1) return new double[0][0];

        double maxTotal = -Double.MAX_VALUE;
        int targetRow = 0;

        for (int i = 0; i < rows; i++) {
            double currentTotal = 0;
            for (double val : M[i]) currentTotal += val;
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                targetRow = i;
            }
        }

        double[][] newM = new double[rows - 1][cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            if (i == targetRow) continue;
            newM[k++] = M[i];
        }
        System.out.println("c. Đã xóa dòng số " + (targetRow + 1) + " (tổng = " + maxTotal + ")");
        return newM;
    }
}