import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
        int n = events.length;
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) ends[i] = events[i][1];
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int start = events[i - 1][0], value = events[i - 1][2];
            int prev = upperBound(ends, start - 1);
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[prev + 1][j - 1] + value);
            }
        }

        return dp[n][k];
    }

    private int upperBound(int[] ends, int target) {
        int lo = 0, hi = ends.length - 1, res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (ends[mid] < target + 1) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}
