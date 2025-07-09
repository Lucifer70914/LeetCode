import java.util.*;

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> gaps = new ArrayList<>();
        
        gaps.add(startTime[0] - 0);
        
        for (int i = 1; i < n; i++) {
            gaps.add(startTime[i] - endTime[i-1]);
        }
        
        gaps.add(eventTime - endTime[n-1]);
        
        int maxGap = 0;
        int currentSum = 0;
        int windowSize = k + 1;
        
        if (windowSize >= gaps.size()) {
            int total = 0;
            for (int gap : gaps) {
                total += gap;
            }
            return total;
        }
        
        for (int i = 0; i < windowSize; i++) {
            currentSum += gaps.get(i);
        }
        
        maxGap = currentSum;
        
        for (int i = windowSize; i < gaps.size(); i++) {
            currentSum += gaps.get(i) - gaps.get(i - windowSize);
            maxGap = Math.max(maxGap, currentSum);
        }
        
        return maxGap;
    }
}