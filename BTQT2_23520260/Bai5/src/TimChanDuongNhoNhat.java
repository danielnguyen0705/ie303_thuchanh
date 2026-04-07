public class TimChanDuongNhoNhat {
    public void giai(double[][] M) {
        double min = Double.MAX_VALUE;
        boolean found = false;
        for (double[] row : M) {
            for (double val : row) {
                if (val > 0 && val % 2 == 0) {
                    if (val < min) {
                        min = val;
                        found = true;
                    }
                }
            }
        }
        if (found) System.out.println("a. Số chẵn dương nhỏ nhất: " + min);
        else System.out.println("a. Không có số chẵn dương.");
    }
}