import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng điểm vẽ trong đồ thị để tính Pi: ");
        
        if (scanner.hasNextDouble()) {
            double precision = scanner.nextDouble();
            
            PiApproximator approximator = new PiApproximator(precision);
            
            double piEstimate = approximator.estimatePi();
            
            System.out.printf("Giá trị Pi xấp xỉ: %.10f\n", piEstimate);
            System.out.printf("Giá trị Pi thực tế: %.10f\n", Math.PI);
            System.out.printf("Sai số: %.10f\n", Math.abs(piEstimate - Math.PI));
        } else {
            System.out.println("Vui lòng nhập một con số hợp lệ.");
        }
        
        scanner.close();
    }
}