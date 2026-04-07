public class KiemTraMaTranVuongTamGiac {
    public void giai(double[][] M) {
        int r = M.length;
        int c = M[0].length;
        if (r != c) {
            System.out.println("d. M không phải ma trận vuông.");
            return;
        }

        boolean upper = true, lower = true;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i > j && M[i][j] != 0) upper = false;
                if (i < j && M[i][j] != 0) lower = false;
            }
        }
        System.out.print("d. M là ma trận vuông. ");
        if (upper) System.out.print("Là ma trận tam giác trên. ");
        if (lower) System.out.print("Là ma trận tam giác dưới. ");
        System.out.println();
    }
}