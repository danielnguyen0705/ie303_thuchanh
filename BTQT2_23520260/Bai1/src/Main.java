import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhap vao so nguyen duong n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Vui long nhap vao mot so nguyen duong.");
        } else {
            // Câu a
            System.out.println("a. Chu so dau tien cua n la: " + TimChuSoDauTien.giai(n));
            
            // Câu b
            boolean checkLe = KiemTraChuSoLe.giai(n);
            System.out.println("b. n co toan chu so le hay khong?:" + (checkLe ? "Co" : "Khong"));
            
            // Câu c
            System.out.println("c. Tich cac uoc so cua n la: " + TinhTichUocSo.giai(n));
            
            // Câu d
            boolean checkHT = KiemTraSoHoanThien.giai(n);
            System.out.println("d. n co phai la so hoan thien hay khong? " + (checkHT ? "Phai" : "Khong phai"));
        }
        
        sc.close();
    }
}