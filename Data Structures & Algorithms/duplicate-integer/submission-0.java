class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            if (numSet.contains(num)) {
                return true;
            } else {
                numSet.add(num);
            }
        }

        return false;
    }
}