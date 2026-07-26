class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                int charASCII = c-'a';
                count[charASCII]++;
            }
            String key = Arrays.toString(count);
            if (!resMap.containsKey(key)) {
                resMap.put(key, new ArrayList<>(List.of(s)));
            } else {
                resMap.get(key).add(s);
            }
        }

        return new ArrayList<>(resMap.values());
    }
}
