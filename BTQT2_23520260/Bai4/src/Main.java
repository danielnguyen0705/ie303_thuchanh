import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Nhập số lượng phần tử (số lượng cạnh)
        System.out.print("Nhap so luong phan tu (so canh): ");
        int n = sc.nextInt();

        if (n < 3) {
            System.out.println("Can ith it nhat 3 de tao thanh tam giac");
            return;
        }

        //Nhập giá trị các cạnh
        int[] arr = new int[n];
        System.out.println("Nhap do dai cac canh:");
        for (int i = 0; i < n; i++) {
            System.out.print("Canh thu " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        //Khởi tạo đối tượng từ class DemTamGiac
        DemTamGiac bai4 = new DemTamGiac();

        bai4.giai(arr);

        sc.close();
    }
}