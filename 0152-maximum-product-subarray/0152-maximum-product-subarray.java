class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            if (curr < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(curr, max * curr);
            min = Math.min(curr, min * curr);

            result = Math.max(result, max);
        }

        return result;
    }
}
