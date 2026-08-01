class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // 0 to amount values
        Arrays.fill(dp, 20000);
        // base case
        dp[0] = 0;

        // build dp array
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }

        if (dp[amount] == 20000) {
            return -1;
        }

        return dp[amount];
    }
}
