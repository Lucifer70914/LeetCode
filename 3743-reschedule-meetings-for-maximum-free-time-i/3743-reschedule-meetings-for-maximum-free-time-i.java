class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];
        
        gaps[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }
        gaps[n] = eventTime - endTime[n - 1];
        
        int maxGap = 0;
        int currentSum = 0;
        int windowSize = k + 1;
        
        if (windowSize >= gaps.length) {
            for (int gap : gaps) {
                maxGap += gap;
            }
            return maxGap;
        }
        
        for (int i = 0; i < windowSize; i++) {
            currentSum += gaps[i];
        }
        maxGap = currentSum;
        
        for (int i = windowSize; i < gaps.length; i++) {
            currentSum += gaps[i] - gaps[i - windowSize];
            if (currentSum > maxGap) {
                maxGap = currentSum;
            }
        }
        
        return maxGap;
    }
}