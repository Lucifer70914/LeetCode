class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); 

        int prefixSum = 0;
        int result = 0;

        for (int num : nums) {
            prefixSum += num;
            if (prefixCount.containsKey(prefixSum - k)) {
                result += prefixCount.get(prefixSum - k);
            }
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
    }
}
