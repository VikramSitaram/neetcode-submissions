class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int leading = 1;
        int trailing = 0;
        int max = 0;

        while (leading < prices.length) {
            if (prices[leading] > prices[trailing]) {
                int diff = prices[leading] - prices[trailing];
                max = Math.max(max, diff);
                leading++;
                continue;
            }

            trailing = leading;
            leading++;
        }

        return max;
    }
}
