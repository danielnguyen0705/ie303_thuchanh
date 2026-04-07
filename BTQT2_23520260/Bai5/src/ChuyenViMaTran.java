public class ChuyenViMaTran {
    public void giai(double[][] tich) {
        if (tich.length == 0) return;
        int r = tich.length;
        int c = tich[0].length;
        double[][] cv = new double[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cv[j][i] = tich[i][j];
            }
        }
        System.out.println("f. Đã thực hiện chuyển vị ma trận tích.");
    }
}