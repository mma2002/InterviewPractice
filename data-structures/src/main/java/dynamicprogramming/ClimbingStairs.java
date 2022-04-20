package dynamicprogramming;

public class ClimbingStairs {
    int solution(int n) {
        int[] fib = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            fib[i] = i;
            if (i >= 2)
                fib[i] = fib[i - 1] + fib[i - 2];


            sum += fib[i];
        }
        return sum + 1;
    }

}
