class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            List<List<String>> res = new ArrayList<>();
            res.add(List.of(strs[0]));
            return res;
        }

        Map<String, List<String>> anagrams = new HashMap<>();

        for (String s : strs) {
            int[] charCount = new int[26];
            for (char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }

            String key = Arrays.toString(charCount);
            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }
            anagrams.get(key).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }
}
