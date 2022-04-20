package bits;

public class SingleNumber {
    int solution(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

}
