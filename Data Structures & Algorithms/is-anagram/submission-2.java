class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            sMap.put(currChar, sMap.getOrDefault(currChar, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            tMap.put(currChar, tMap.getOrDefault(currChar, 0) + 1);
        }

        return sMap.equals(tMap);
    }
}
