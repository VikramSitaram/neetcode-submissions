class Solution {
    public int rob(int[] nums) {
        // handle empty or tiny streets
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int n = nums.length;
        int[] memo = new int[n];

        // base cases for index 0 and index 1
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        // process all houses starting at index 2
        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(nums[i] + memo[i-2], memo[i - 1]);
        }

        return memo[n - 1];
    }
}

