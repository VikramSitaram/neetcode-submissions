class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1]; // 0 to amount values
        Arrays.fill(memo, amount + 1);
        // base case
        memo[0] = 0;

        // build memo array
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    memo[i] = Math.min(memo[i], 1 + memo[i - c]);
                }
            }
        }

        if (memo[amount] == amount + 1) {
            return -1;
        }

        return memo[amount];
    }
}
