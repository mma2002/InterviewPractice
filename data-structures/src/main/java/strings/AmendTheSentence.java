package strings;

public class AmendTheSentence {
    String solution(String s) {
        String result = new String();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i)))
                result += " " + Character.toLowerCase(s.charAt(i));
            else result += Character.toLowerCase(s.charAt(i));
        }
        return result.trim();
    }

}
