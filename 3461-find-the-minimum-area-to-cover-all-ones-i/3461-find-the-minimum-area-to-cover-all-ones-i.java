class Solution {
    public int minimumArea(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int rmin=m, rmax=-1;
        int cmin=n,cmax=-1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    rmin=Math.min(rmin,i);
                    rmax=Math.max(rmax,i);
                    cmin=Math.min(cmin,j);
                    cmax=Math.max(cmax,j);
                }
            }
        }
        int h=rmax-rmin+1;
        int w=cmax-cmin+1;
        return h*w;
        
    }
}