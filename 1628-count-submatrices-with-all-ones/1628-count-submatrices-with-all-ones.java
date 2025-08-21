class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] heights = new int[m][n];
        for (int j = 0; j < n; j++) {
            heights[0][j] = mat[0][j];
            for (int i = 1; i < m; i++) {
                heights[i][j] = mat[i][j] == 0 ? 0 : heights[i - 1][j] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minHeight = heights[i][j];
                for (int k = j; k >= 0 && minHeight > 0; k--) {
                    minHeight = Math.min(minHeight, heights[i][k]);
                    ans += minHeight;
                }
            }
        }
        return ans;
    }
}
