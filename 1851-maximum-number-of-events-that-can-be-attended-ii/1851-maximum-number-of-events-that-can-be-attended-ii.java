import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int[] curr = events[i - 1];
            int prev = binarySearch(events, curr[0], i - 1);
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[prev + 1][j - 1] + curr[2]);
            }
        }

        return dp[n][k];
    }

    private int binarySearch(int[][] events, int start, int hi) {
        int lo = 0, res = -1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (events[mid][1] < start) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}
