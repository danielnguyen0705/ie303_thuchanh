import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Khởi tạo đối tượng Scanner để nhập liệu
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập vào tổng số giây: ");
        int totalSeconds = scanner.nextInt();
        
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        
        //Hiển thị kết quả ra màn hình
        System.out.println("Số Giờ : " + hours);
        System.out.println("Số Phút : " + minutes);
        System.out.println("Số Giây : " + seconds);
        
        scanner.close();
    }
}