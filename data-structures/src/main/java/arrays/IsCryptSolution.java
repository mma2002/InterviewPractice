package arrays;

import java.util.HashMap;
import java.util.Map;

public class IsCryptSolution {
    boolean solution(String[] crypt, char[][] solution) {
        Map<Character, String> mapSolutions = new HashMap<>();
        for (int i = 0; i < solution.length; i++) {
            mapSolutions.put(solution[i][0], String.valueOf(solution[i][1]));
        }


        String[] decrypt = new String[3];

        for (int i = 0; i < crypt.length; i++) {
            String buf = new String();
            String word = crypt[i];
            for (int j = 0; j < word.length(); j++) {
                Character c = word.charAt(j);
                buf += mapSolutions.get(c);
            }
            decrypt[i] = buf;
            if (String.valueOf(decrypt[i].charAt(0)).equals("0") && decrypt[i].length() > 1) return Boolean.FALSE;
        }

        if (Long.parseLong(decrypt[0]) + Long.parseLong(decrypt[1]) != Long.parseLong(decrypt[2]))
            return Boolean.FALSE;

        return Boolean.TRUE;

    }

}
