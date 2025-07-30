class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int s=0;
        int sum=1;
        int ans=0;
        for(int i=0;i<nums.length;i++){
             sum=sum*nums[i];
            while(sum>=k&&s<=i){
                sum=sum/nums[s];
                s++;
            }
           
           
            if(sum<k){
                ans=ans+i-s+1;
            }


        }
        return ans;
        
    }
}