import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Nhập số lượng phần tử của mảng
        System.out.print("Nhap vao so luong n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("So luong khong hop le!");
            return;
        }

        //Nhập các phần tử
        int[] arr = new int[n];
        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu [" + i + "]: ");
            arr[i] = sc.nextInt();
        }

        MangConLienTiep bai3 = new MangConLienTiep();
        
        bai3.giai(arr);

        sc.close();
    }
}