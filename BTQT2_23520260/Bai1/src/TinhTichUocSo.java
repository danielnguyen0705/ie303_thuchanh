//Câu c: Tính tích các ước số của n
public class TinhTichUocSo {
    public static long giai(int n) {
        long tich = 1;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                tich *= i;
            }
        }
        return tich;
    }
}