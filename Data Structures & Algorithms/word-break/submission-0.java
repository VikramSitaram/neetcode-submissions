class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // optimize lookup times to O(1)
        Set<String> wordSet = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, false);

        // base case: empty prefix is always valid
        dp[0] = true;

        // loop through all prefix lengths
        for (int i = 0; i <= n; i++) {
            // check for valid cutting points
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
