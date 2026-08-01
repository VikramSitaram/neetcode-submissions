class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uniques = new HashSet<>();
        int l = 0;
        int longest = 0;

        for (int r = 0; r < s.length(); r++) {
            char current = s.charAt(r);
            while (uniques.contains(current)) {
                uniques.remove(s.charAt(l));
                l++;
            }
            uniques.add(s.charAt(r));
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
