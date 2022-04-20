package hashtables;

public class ContainsCloseNums {
    boolean solution(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    int t = Math.abs(i - j);
                    if (t <= k) return Boolean.TRUE;
                }
            }

        }
        return Boolean.FALSE;
    }

}
