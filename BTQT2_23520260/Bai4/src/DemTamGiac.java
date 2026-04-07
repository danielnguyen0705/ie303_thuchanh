import java.util.Arrays;

public class DemTamGiac {
    public void giai(int[] arr) {
        int n = arr.length;
        int count = 0;

        // Sắp xếp mảng để dễ kiểm tra điều kiện
        Arrays.sort(arr);

        // Duyệt qua từng bộ 3 số i, j, k
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Bất đẳng thức tam giác: a + b > c
                    if (arr[i] + arr[j] > arr[k]) {
                        count++;
                    } else {
                        // Vì mảng đã sắp xếp, nếu arr[i] + arr[j] <= arr[k] thì chắc chắn nó cũng sẽ nhỏ hơn các số sau arr[k]
                        break; 
                    }
                }
            }
        }
        System.out.println("So tam giac co the tao thanh: " + count);
    }
}