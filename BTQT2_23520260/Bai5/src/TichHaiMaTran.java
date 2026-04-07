public class TichHaiMaTran {
    public double[][] giai(double[][] M) {
        int m = M.length;
        int n = M[0].length;
        double[][] N = new double[n][m]; 
        // Giả sử N có các phần tử bằng 1.0 để demo
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) N[i][j] = 1.0;

        double[][] result = new double[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += M[i][k] * N[k][j];
                }
            }
        }
        System.out.println("e. Đã tính xong tích ma trận M x N (kích thước " + m + "x" + m + ")");
        return result;
    }
}