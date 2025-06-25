class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L, right = 10000000000L;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLessEqual(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long x) {
        long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                count += countPos(a, nums2, x);
            } else if (a < 0) {
                count += countNeg(a, nums2, x);
            } else {
                // a == 0, product is 0
                if (x >= 0) count += nums2.length;
            }
        }
        return count;
    }

    private long countPos(int a, int[] nums2, long x) {
        int l = 0, r = nums2.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((long)a * nums2[m] <= x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private long countNeg(int a, int[] nums2, long x) {
        int l = 0, r = nums2.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((long)a * nums2[m] <= x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return nums2.length - l;
    }
}
