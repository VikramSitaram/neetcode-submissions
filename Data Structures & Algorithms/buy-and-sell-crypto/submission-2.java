class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int max = 0;
        int i = 1;
        int j = 0;

        while (i <= prices.length - 1) {
            if (prices[i] > prices[j]) {
                int diff = prices[i] - prices[j];
                max = (diff > max) ? diff : max;
            } else {
                j = i;
            }
            i++;
        }

        return max;
    }
}
