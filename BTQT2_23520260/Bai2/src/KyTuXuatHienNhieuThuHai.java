//Câu b: Kiểm tra xem ký tự nào xuất hiện nhiều thứ hai trong chuỗi s
public class KyTuXuatHienNhieuThuHai {
    public static char giai(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) count[c]++;

        int max1 = 0;
        char res = '\0';

        // Tìm tần suất lớn nhất (max1)
        for (int i = 0; i < 256; i++) {
            if (count[i] > count[max1]) max1 = i;
        }

        // Tìm tần suất lớn thứ hai (max2)
        int firstMaxVal = count[max1];
        int secondMaxVal = -1;
        
        for (int i = 0; i < 256; i++) {
            if (count[i] < firstMaxVal && count[i] > secondMaxVal) {
                secondMaxVal = count[i];
                res = (char) i;
            }
        }
        return res;
    }
}