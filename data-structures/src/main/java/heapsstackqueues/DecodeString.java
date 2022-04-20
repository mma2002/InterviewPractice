package heapsstackqueues;

import java.util.Stack;

public class DecodeString {
    String solution(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<String> str = new Stack<>();
        String result = "";
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = 10 * count + s.charAt(i) - '0';
                    i++;
                }
                numbers.push(count);
            } else if (s.charAt(i) == '[') {
                str.push(result);
                result = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(str.pop());
                int count = numbers.pop();
                for (int j = 0; j < count; j++) {
                    temp.append(result);
                }
                result = temp.toString();
                i++;
            } else {
                result += s.charAt(i);
                i++;
            }
        }
        return result;
    }

}
