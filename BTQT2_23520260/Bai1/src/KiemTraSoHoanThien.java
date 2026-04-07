//Câu d: Kiểm tra xem n có phải là số hoàn thiện hay không
//Số hoàn thiện là số có tổng các ước số dương của nó (không bao gồm chính nó) bằng chính nó.
//Ví dụ: 6 là số hoàn thiện vì 1 + 2 + 3 = 6, còn 8 không phải là số hoàn thiện vì 1 + 2 + 4 = 7.
public class KiemTraSoHoanThien {
    public static boolean giai(int n) {
        if (n <= 0) return false;
        int tong = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                tong += i;
            }
        }
        return tong == n;
    }
}