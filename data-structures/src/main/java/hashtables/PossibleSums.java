package hashtables;

import java.util.HashSet;
import java.util.Set;

public class PossibleSums {
    int solution(int[] coins, int[] quantity) {
        Set<Integer> sums = new HashSet<>();
        getSums(coins, quantity, sums, 0, 0);

        return sums.size();
    }

    void getSums(int[] coins, int[] quantity, Set<Integer> sums, int sum, int pos) {
        for (int i = pos; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 1; j <= quantity[i]; j++) {
                int innerSum = sum;
                innerSum += coin * j;
                sums.add(innerSum);
                getSums(coins, quantity, sums, innerSum, i + 1);
            }
        }
    }
}
