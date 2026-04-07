//Câu b: Kiểm tra xem tất cả các chữ số của n có phải là số lẻ hay không
public class KiemTraChuSoLe {
    public static boolean giai(int n) {
        int temp = n;
        while (temp > 0) {
            int chuSo = temp % 10;
            if (chuSo % 2 == 0) {
                return false; // Thấy 1 chữ số chẵn là loại ngay
            }
            temp /= 10;
        }
        return true;
    }
}