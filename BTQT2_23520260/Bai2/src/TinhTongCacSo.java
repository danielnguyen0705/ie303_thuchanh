//Câu c: Tính tổng các số xuất hiện trong chuỗi s
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TinhTongCacSo {
    public static int giai(String s) {
        int tong = 0;
        // Biểu thức chính quy tìm các chuỗi chữ số liên tiếp
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);
        
        while (m.find()) {
            tong += Integer.parseInt(m.group());
        }
        return tong;
    }
}