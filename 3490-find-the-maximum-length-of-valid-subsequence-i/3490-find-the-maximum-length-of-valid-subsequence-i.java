class Solution {
    public int maximumLength(int[] nums) {
        int evenCount = 0;
        int oddCount = 0;
        
        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        int maxUniform = Math.max(evenCount, oddCount);
        
        int maxAlternating = 0;
        int current = 0; // 0 for even, 1 for odd
        int count = 0;
        
        // Case 1: Start with even
        current = 0;
        count = 0;
        for (int num : nums) {
            if (current == 0 && num % 2 == 0) {
                count++;
                current = 1;
            } else if (current == 1 && num % 2 != 0) {
                count++;
                current = 0;
            }
        }
        maxAlternating = Math.max(maxAlternating, count);
        
        // Case 2: Start with odd
        current = 1;
        count = 0;
        for (int num : nums) {
            if (current == 1 && num % 2 != 0) {
                count++;
                current = 0;
            } else if (current == 0 && num % 2 == 0) {
                count++;
                current = 1;
            }
        }
        maxAlternating = Math.max(maxAlternating, count);
        
        return Math.max(maxUniform, maxAlternating);
    }
}