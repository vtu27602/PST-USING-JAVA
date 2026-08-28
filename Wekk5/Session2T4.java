class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalsum = 0;

        int currentmax = 0;
        int totalmax = nums[0];

        int currentmin = 0;
        int totalmin = nums[0];

        for (int i = 0; i < nums.length; i++) {

            currentmax = Math.max(nums[i], currentmax + nums[i]);
            totalmax = Math.max(totalmax, currentmax);

            currentmin = Math.min(nums[i], currentmin + nums[i]);
            totalmin = Math.min(totalmin, currentmin);

            totalsum = totalsum + nums[i];
        }

        if (totalmax < 0) {
            return totalmax;
        }

        int circularmax = totalsum - totalmin;

        return Math.max(totalmax, circularmax);
    }
}

Input: nums = [1,-2,3,-2]
Output: 3
