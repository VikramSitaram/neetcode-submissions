class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        Set<Character> uniques = new HashSet<>();
        int l = 0;
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            while (uniques.contains(c)) {
                uniques.remove(s.charAt(l));
                l++;
            }

            uniques.add(c);
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
