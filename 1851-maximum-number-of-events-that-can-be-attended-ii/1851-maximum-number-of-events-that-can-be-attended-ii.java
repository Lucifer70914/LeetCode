import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) ends[i] = events[i][1];

        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                int idx = upperBound(ends, events[j - 1][0] - 1);
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][idx + 1] + events[j - 1][2]);
            }
        }

        return dp[k][n];
    }

    private int upperBound(int[] ends, int target) {
        int lo = 0, hi = ends.length - 1, res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (ends[mid] <= target) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}
