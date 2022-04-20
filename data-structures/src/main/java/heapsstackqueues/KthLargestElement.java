package heapsstackqueues;

import java.util.PriorityQueue;

public class KthLargestElement {
    int solution(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(k);
        for (int i = 0; i < nums.length; i++) {

            pQueue.add(nums[i]);

        }
        int x = nums.length - k;

        for (int i = 0; i < nums.length; i++) {
            if (i < x) pQueue.poll();
            else break;

        }
        return pQueue.peek();

    }

}
