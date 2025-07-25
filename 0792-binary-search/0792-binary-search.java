class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int start=0,end=len-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]==target)
            return mid;
            if(nums[mid]>target)
            end=mid-1;
            else
            start=mid+1;
        }
        return -1;
        
    }
}