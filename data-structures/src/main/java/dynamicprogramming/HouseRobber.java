package dynamicprogramming;

public class HouseRobber {
    int solution(int[] nums) {
        int max = 0;
        if (nums.length == 0) return max;
        else if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];
        dp[nums.length - 2] = Math.max(nums[nums.length - 2], nums[nums.length - 1]);
        dp[nums.length - 3] = Math.max(nums[nums.length - 3] + dp[nums.length - 1], dp[nums.length - 2]);
        for (int i = nums.length - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
            int temp = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
            if (temp > max) max = temp;

        }
        return max;
    }

}
