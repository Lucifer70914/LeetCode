class Solution {
    static final int MOD = 1_000_000_007;
    Integer[][] dp;

    public int numberOfWays(int n, int x) {
        dp = new Integer[n + 1][n + 1];
        return helper(1, n, x);
    }

    private int helper(int curr, int remaining, int x) {
        if (remaining == 0) return 1;
        if (remaining < 0) return 0;

        int power = (int) Math.pow(curr, x);
        if (power > remaining) return 0;

        if (dp[curr][remaining] != null) return dp[curr][remaining];
        int take = helper(curr + 1, remaining - power, x) % MOD;
        int skip = helper(curr + 1, remaining, x) % MOD;

        return dp[curr][remaining] = (take + skip) % MOD;
    }
}
