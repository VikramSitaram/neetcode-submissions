class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder firstPass = new StringBuilder();
        int count = 0;

        for (int i=0;i<s.length();i++) {
            char firstPassChar = s.charAt(i);
            if (firstPassChar == '(') {
                firstPass.append(firstPassChar);
                count++;
            } else if (firstPassChar == ')' && count > 0) {
                firstPass.append(firstPassChar);
                count--;
            } else if (firstPassChar == ')' && count == 0) {
                continue;
            } else {
                firstPass.append(firstPassChar);
            }
        }

        if (count == 0) {
            return firstPass.toString();
        } else {
            System.out.println("count: " + count);
            StringBuilder secondPass = new StringBuilder();
            String firstPassString = firstPass.toString();
            for (int j=firstPassString.length()-1;j>=0;j--) {
                char secondPassChar = firstPassString.charAt(j);
                if (count > 0 && secondPassChar == '(') {
                    count--;
                    continue;
                } else {
                    secondPass.append(secondPassChar);
                }
            }

            return secondPass.reverse().toString();
        }
    }
}