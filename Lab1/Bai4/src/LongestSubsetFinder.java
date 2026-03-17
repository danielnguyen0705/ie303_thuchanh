import java.util.*;

public class LongestSubsetFinder {
    
    public List<Integer> findLongestSubset(int[] arr, int k) {
        // dp[i] lưu số lượng phần tử tối đa để đạt được tổng i
        int[] dp = new int[k + 1];
        // parent[i] lưu giá trị số vừa được chọn để đạt được tổng i (phục vụ truy vết)
        int[] parent = new int[k + 1];
        
        Arrays.fill(dp, -1);
        Arrays.fill(parent, -1);
        dp[0] = 0; // Tổng bằng 0 luôn có 0 phần tử

        // Duyệt qua từng số trong danh sách A
        for (int num : arr) {
            // Duyệt ngược từ k về num để đảm bảo mỗi số chỉ dùng 1 lần 
            for (int s = k; s >= num; s--) {
                if (dp[s - num] != -1) {
                    // Nếu việc thêm số hiện tại giúp dãy dài hơn thì cập nhật
                    if (dp[s - num] + 1 > dp[s]) {
                        dp[s] = dp[s - num] + 1;
                        parent[s] = num;
                    }
                }
            }
        }

        // Truy vết để lấy danh sách các số đã chọn
        List<Integer> result = new ArrayList<>();
        if (dp[k] == -1) return result; // Không tìm thấy dãy con thỏa mãn

        int currentSum = k;
        while (currentSum > 0) {
            int val = parent[currentSum];
            result.add(val);
            currentSum -= val;
        }
        
        // Sắp xếp lại hoặc giữ nguyên tùy ý, ở đây trả về theo thứ tự truy vết
        return result;
    }
}