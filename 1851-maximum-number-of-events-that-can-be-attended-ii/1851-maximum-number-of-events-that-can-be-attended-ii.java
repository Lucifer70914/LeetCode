import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int n = events.length;
        Integer[][] memo = new Integer[n][k + 1];
        int[] startTimes = new int[n];
        for (int i = 0; i < n; i++) startTimes[i] = events[i][0];

        return dfs(0, k, events, memo, startTimes);
    }

    private int dfs(int index, int k, int[][] events, Integer[][] memo, int[] startTimes) {
        if (index == events.length || k == 0) return 0;
        if (memo[index][k] != null) return memo[index][k];
        int skip = dfs(index + 1, k, events, memo, startTimes);
        int nextIndex = findNext(events, index, startTimes);
        int take = events[index][2] + dfs(nextIndex, k - 1, events, memo, startTimes);

        return memo[index][k] = Math.max(skip, take);
    }

    private int findNext(int[][] events, int curr, int[] startTimes) {
        int lo = curr + 1, hi = events.length;
        int target = events[curr][1];

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (startTimes[mid] > target) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }
}
