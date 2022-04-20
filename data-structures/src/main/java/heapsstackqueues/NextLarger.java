package heapsstackqueues;

import java.util.ListIterator;
import java.util.Stack;

public class NextLarger {
    int[] solution(int[] a) {
        int[] result = new int[a.length];
        Stack<Integer> numbers = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            numbers.push(a[i]);
        }

        for (int i = 0; i < a.length; i++) {
            ListIterator<Integer> iter = numbers.listIterator(numbers.size());
            while (iter.hasPrevious()) {
                int num = iter.previous();
                if (num > a[i]) {
                    result[i] = num;
                    numbers.pop();
                    break;
                }
            }
            if (result[i] == 0) {
                numbers.pop();
                result[i] = -1;
            }
        }
        return result;

    }

}
