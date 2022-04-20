package strings;

public class Strstr {
    int solution(String s, String x) {

        int M = x.length();
        int N = s.length();

        int lps[] = new int[M];
        int j = 0;

        for (int i = 0; i < M; i++) {
            lps[i] = i;
        }

        int i = 0;
        while (i < N) {
            if (x.charAt(j) == s.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) return (i - j);
            else if (i < N && x.charAt(j) != s.charAt(i)) {

                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return -1;
    }

}
