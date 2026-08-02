class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // optimize lookup times to O(1)
        Set<String> wordSet = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] memo = new boolean[n + 1];
        Arrays.fill(memo, false);

        // base case: empty prefix is always valid
        memo[0] = true;

        // loop through all prefix lengths
        for (int i = 0; i <= n; i++) {
            // check for valid cutting points
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordSet.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[n];
    }
}
