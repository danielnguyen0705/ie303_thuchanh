// Câu a: Đếm số lượng chữ cái, khoảng trắng, số và các ký tự khác trong chuỗi s
public class DemKyTu {
    public static void giai(String s) {
        int chuCai = 0, khoangTrang = 0, so = 0, khac = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) chuCai++;
            else if (Character.isDigit(c)) so++;
            else if (Character.isWhitespace(c)) khoangTrang++;
            else khac++;
        }
        System.out.println("a. Chu cai: " + chuCai + ", Khoang Trang: " + khoangTrang + ", So: " + so + ", Cac ky tu khac: " + khac);
    }
}