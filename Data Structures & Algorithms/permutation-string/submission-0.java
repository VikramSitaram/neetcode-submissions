class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s2.length()) {
            return false;
        }

        int[] s1Arr = new int[26];
        for (char c : s1.toCharArray()) {
            s1Arr[c-'a']++;
        }
        String s1ASCII = Arrays.toString(s1Arr);
        System.out.println("s1ASCII: " + s1ASCII);

        int l = 0, r = s1.length();
        while (r <= s2.length()) {
            String currSubstr = s2.substring(l++, r++);
            int[] s2SubArr = new int[26];
            for (char c : currSubstr.toCharArray()) {
                s2SubArr[c-'a']++;
            }
            String s2SubASCII = Arrays.toString(s2SubArr);
            System.out.println("ASCII for " + currSubstr + ": " + s2SubASCII);
            if (s2SubASCII.equals(s1ASCII)) {
                return true;
            }
        }

        return false;
    }
}
