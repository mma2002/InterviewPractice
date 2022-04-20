package dynamicprogramming;

public class ComposeRanges {
    String[] solution(int[] nums) {
        String res = new String();
        if (nums.length == 0) return new String[0];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + "=" + nums[i]);
            if ((k == 0 && i < nums.length - 1) || nums.length == 1) {
                if (res.isEmpty() || res.charAt(res.length() - 1) == ',' || res.charAt(res.length() - 1) == '>')
                    res += nums[i];
            }

            if (i < nums.length - 1 && (Math.abs(nums[i + 1] - nums[i])) > 1) {
                res += (k > 0 ? "->" + nums[i] + "," : "," + nums[i + 1]);

                k = 0;
            } else {
                if (i == nums.length - 1 && k > 0) {
                    res += "->" + nums[i];
                } else if (i == nums.length - 1 && k == 0 && i > 1 &&
                        (res.charAt(res.length() - 1) == ',' || res.charAt(res.length() - 1) == '>')) {
                    res += nums[i];
                }
                k++;
            }
        }
        return res.split(",");
    }

}
