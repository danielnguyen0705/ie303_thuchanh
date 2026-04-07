import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MangConLienTiep {
    public void giai(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Khong ton tai mang con lien tiep.");
            return;
        }

        // Bước 1: Sắp xếp mảng để các số liên tiếp đứng cạnh nhau
        Arrays.sort(arr);

        List<Integer> maxSub = new ArrayList<>();
        List<Integer> currentSub = new ArrayList<>();

        // Thêm phần tử đầu tiên vào mảng con hiện tại
        currentSub.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            // Nếu phần tử hiện tại bằng phần tử trước đó + 1 (Liên tiếp)
            if (arr[i] == arr[i - 1] + 1) {
                currentSub.add(arr[i]);
            } 
            // Nếu là số trùng lặp thì bỏ qua
            else if (arr[i] == arr[i - 1]) {
                continue;
            }
            // Nếu bị ngắt quãng
            else {
                if (currentSub.size() > maxSub.size()) {
                    maxSub = new ArrayList<>(currentSub);
                }
                currentSub.clear();
                currentSub.add(arr[i]);
            }
        }

        // Kiểm tra lần cuối sau khi kết thúc vòng lặp
        if (currentSub.size() > maxSub.size()) {
            maxSub = new ArrayList<>(currentSub);
        }

        // Bước 2: In kết quả
        if (maxSub.size() > 1) {
            System.out.println("Mang con lien tiep dai nhat la: " + maxSub);
        } else {
            System.out.println("Khong ton tai mang con lien tiep.");
        }
    }
}