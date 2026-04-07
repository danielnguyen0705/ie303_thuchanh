//Câu a: Tìm chữ số đầu tiên của n
public class TimChuSoDauTien {
    public static int giai(int n) {
        int temp = n;
        while (temp >= 10) {
            temp /= 10;
        }
        return temp;
    }
}