class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int k = 0; k < n; k++) {
            List<Integer> diag = new ArrayList<>();
            int i = k, j = 0;
            while (i < n && j < n) {
                diag.add(grid[i][j]);
                i++;
                j++;
            }
            if (k >= 0) Collections.sort(diag, Collections.reverseOrder());
            i = k;
            j = 0;
            int idx = 0;
            while (i < n && j < n) {
                grid[i][j] = diag.get(idx++);
                i++;
                j++;
            }
        }
        for (int k = 1; k < n; k++) {
            List<Integer> diag = new ArrayList<>();
            int i = 0, j = k;
            while (i < n && j < n) {
                diag.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(diag);
            i = 0;
            j = k;
            int idx = 0;
            while (i < n && j < n) {
                grid[i][j] = diag.get(idx++);
                i++;
                j++;
            }
        }
        return grid;
    }
}
