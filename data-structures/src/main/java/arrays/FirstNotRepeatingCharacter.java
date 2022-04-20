package arrays;

public class FirstNotRepeatingCharacter {
    char solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int first = s.indexOf(c.toString());
            int last = s.lastIndexOf(c.toString());
            if (first == last) return c;
        }
        return '_';
    }
}
