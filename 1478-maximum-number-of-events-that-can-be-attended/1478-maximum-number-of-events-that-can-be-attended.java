import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, n = events.length;
        int res = 0;
        int maxDay = 0;
        for (int[] e : events) maxDay = Math.max(maxDay, e[1]);

        for (int day = 1; day <= maxDay; day++) {
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
        }

        return res;
    }
}
