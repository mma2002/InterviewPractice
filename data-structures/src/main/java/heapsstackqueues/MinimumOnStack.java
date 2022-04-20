package heapsstackqueues;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MinimumOnStack {
    int[] solution(String[] operations) {
        List<String> list = Arrays.asList(operations);
        long count = list.stream().filter(item -> item.equals("min")).count();
        Stack<Integer> stackAll = new Stack<>();
        Stack<Integer> stackMin = new Stack<>();
        int[] result = new int[(int) count];
        int j = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].startsWith("push")) {
                String str = operations[i].replaceAll("\\D+", "");
                int num = Integer.parseInt(str);
                stackAll.push(num);
                if (stackMin.isEmpty() || stackMin.peek() > num) stackMin.push(num);
                else stackMin.push(stackMin.peek());

            } else if (operations[i].startsWith("pop")) {
                stackAll.pop();
                stackMin.pop();
            } else if (operations[i].startsWith("min")) {
                result[j] = stackMin.peek();
                j++;
            }

        }
        return result;
    }

}
