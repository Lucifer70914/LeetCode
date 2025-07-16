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
        
        int maxAlternating1 = 0; // starts with even
        int current = 0; // 0 for even, 1 for odd
        for (int num : nums) {
            if (current == 0) {
                if (num % 2 == 0) {
                    maxAlternating1++;
                    current = 1;
                }
            } else {
                if (num % 2 != 0) {
                    maxAlternating1++;
                    current = 0;
                }
            }
        }
        
        int maxAlternating2 = 0; // starts with odd
        current = 1;
        for (int num : nums) {
            if (current == 1) {
                if (num % 2 != 0) {
                    maxAlternating2++;
                    current = 0;
                }
            } else {
                if (num % 2 == 0) {
                    maxAlternating2++;
                    current = 1;
                }
            }
        }
        
        int maxAlternating = Math.max(maxAlternating1, maxAlternating2);
        
        return Math.max(maxUniform, maxAlternating);
    }
}