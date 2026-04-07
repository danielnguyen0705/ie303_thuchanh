import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhap vao mot chuoi:");
        String s = sc.nextLine();
        
        // Câu a
        DemKyTu.giai(s);
        
        // Câu b
        char c2 = KyTuXuatHienNhieuThuHai.giai(s);
        System.out.println("b. Ky tu xuat hien nhieu thu hai trong chuoi la: " + (c2 == '\0' ? "Khong co" : "'" + c2 + "'"));
        
        // Câu c
        System.out.println("c. Tong cac so xuat hien trong chuoi: " + TinhTongCacSo.giai(s));
        
        sc.close();
    }
}