class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // optimize lookup times to O(1)
        Set<String> wordSet = new HashSet<>(wordDict);

        // find the length of the longest word in the dictionary
        int maxWordLength = 0;
        for (String word : wordSet) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        int n = s.length();
        boolean[] memo = new boolean[n + 1];
        Arrays.fill(memo, false);

        // base case: empty prefix is always valid
        memo[0] = true;

        // loop through all prefix lengths
        for (int i = 0; i <= n; i++) {
            // optimize the inner loop start boundary
            // j only needs to look back as far as the longest possible word
            int start = Math.max(0, i - maxWordLength);

            // check for valid cutting points
            for (int j = start; j < i; j++) {
                if (memo[j] && wordSet.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[n];
    }
}
