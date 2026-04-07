import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số dòng m: ");
        int m = sc.nextInt();
        System.out.print("Nhập số cột n: ");
        int n = sc.nextInt();

        double[][] M = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("M["+i+"]["+j+"] = ");
                M[i][j] = sc.nextDouble();
            }
        }

        // Gọi các file độc lập
        new TimChanDuongNhoNhat().giai(M);
        new TrungBinhMinCot().giai(M);
        System.out.println("Ma trận sau khi xóa dòng (câu c):");
        for(double[] row : M) System.out.println(java.util.Arrays.toString(row));
        new KiemTraMaTranVuongTamGiac().giai(M);
        
        double[][] tich = new TichHaiMaTran().giai(M);
        new ChuyenViMaTran().giai(tich);

        M = new XoaDongTongMax().giai(M);


        sc.close();
    }
}