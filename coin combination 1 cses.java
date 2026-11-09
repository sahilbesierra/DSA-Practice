import java.util.*;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        long[] dp = new long[x + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= x; sum++) {
            for (int coin : coins) {
                if (sum >= coin) {
                    dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
                }
            }
        }

        System.out.println(dp[x]);
    }
}

int fxn(i,s){
    if (i == 0) {
        return (s == 0) ? 1 : 0;
    }int exclude = fxn(i + 1, s);
    int include=0;
    if (s >= coins[i]) {
        include = fxn(i, s - coins[i]);
    }
    return (exclude + include) % MOD;
}