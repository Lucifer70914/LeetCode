class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int len=dimensions.length;
        int maxd=0,maxArea=0;
        for(int i=0;i<len;i++)
        {
            int l=dimensions[i][0];
            int b=dimensions[i][1];
            int d=l*l+b*b;
            int area=l*b;
            if(maxd<d)
            {
                maxd=d;
                maxArea=area;
            }
            else if(maxd==d && maxArea<area)
            {
                maxArea=area;
            }
        }
        return maxArea;
        
    }
}