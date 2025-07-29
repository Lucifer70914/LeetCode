class Solution {
    public int maxSubArray(int[] nums) {
        int s=0;
        int sum=0;
        int x=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            while(sum<0){
                sum=sum-nums[s];
                s++;
            }
            sum=sum+nums[i];
            x=Math.max(x,sum);

        }
        return x;
        
    }
}