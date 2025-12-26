package hashmap_exercises;
import java.util.HashMap;
import java.util.Map;

public class MaxSumPairEqualDigitSum {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1; for (int num : nums) {
            int sum = digitSum(num);
            if (map.containsKey(sum)) {
                max = Math.max(max, num + map.get(sum));
                map.put(sum, Math.max(map.get(sum), num));
            } else {
                map.put(sum, num);
            }
        } return max;
    }
    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10; x /= 10;
        }
        return sum;
    }
}