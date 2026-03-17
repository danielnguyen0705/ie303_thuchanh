import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo Scanner để nhận dữ liệu từ bàn phím
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập bán kính r: ");

        if (input.hasNextDouble()) {
            double r = input.nextDouble();

            if (r > 0) {
                // Khởi tạo đối tượng Circle
                Circle myCircle = new Circle(r);
                
                double result = myCircle.approximateArea();

                System.out.printf("Diện tích xấp xỉ:  %.5f\n", result);
            } else {
                System.out.println("Lỗi: Bán kính phải lớn hơn 0.");
            }
        } else {
            System.out.println("Lỗi: Dữ liệu nhập vào không phải là số.");
        }

        input.close(); 
    }
}