import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Đọc n và k
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (sc.hasNextInt()) {
                arr[i] = sc.nextInt();
            }
        }

        // Khởi tạo đối tượng xử lý thuật toán
        LongestSubsetFinder finder = new LongestSubsetFinder();
        List<Integer> result = finder.findLongestSubset(arr, k);

        // Hiển thị kết quả
        if (result.isEmpty()) {
            System.out.println("Không có dãy con nào thỏa mãn.");
        } else {
            // In kết quả theo định dạng số, số, số
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i) + (i == result.size() - 1 ? "" : ", "));
            }
            System.out.println();
        }

        sc.close();
    }
}