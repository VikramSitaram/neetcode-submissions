class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minL = Integer.MAX_VALUE;
        int l = 0;
        int slidingSum = 0;

        for (int r = 0; r < nums.length; r++) {
            slidingSum += nums[r];
            // keep incrementing left pointer for all valid sums
            while (slidingSum >= target) {
                minL = Math.min(minL, (r - l + 1));
                slidingSum -= nums[l];
                l++;
            }
        }

        return minL == Integer.MAX_VALUE ? 0 : minL;
    }
}