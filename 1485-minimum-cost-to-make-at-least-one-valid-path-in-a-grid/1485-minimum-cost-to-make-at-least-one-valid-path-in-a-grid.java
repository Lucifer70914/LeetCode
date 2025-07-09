import java.util.PriorityQueue;

class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] cost = new int[rows][cols];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
        
        heap.offer(new int[]{0, 0, 0});
        cost[0][0] = 0;

        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int x = current[0], y = current[1], c = current[2];
            
            if (x == rows - 1 && y == cols - 1) return c;

            if (c > cost[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {
                    int nc = c + (grid[x][y] == i + 1 ? 0 : 1);
                    if (nc < cost[nx][ny]) {
                        cost[nx][ny] = nc;
                        heap.offer(new int[]{nx, ny, nc});
                    }
                }
            }
        }
        
        return -1; 
    }
}