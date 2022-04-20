package hashtables;

import java.util.HashMap;
import java.util.Map;

public class AreFollowingPatterns {
    boolean solution(String[] strings, String[] patterns) {
        Map<String, String> mapStr = new HashMap<>();
        Map<String, String> mapPat = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String pat = patterns[i];
            String str = strings[i];
            String cur = null;
            if (mapStr.containsKey(str)) {
                cur = mapStr.get(str);
                if (!cur.equals(pat)) return Boolean.FALSE;
            } else mapStr.put(str, pat);

            if (mapPat.containsKey(pat)) {
                cur = mapPat.get(pat);
                if (!cur.equals(str)) return Boolean.FALSE;
            } else mapPat.put(pat, str);
        }

        return Boolean.TRUE;
    }

}
