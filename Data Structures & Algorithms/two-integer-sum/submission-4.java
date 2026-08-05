class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] { 0, 1 };
        }

        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int difference = target - num;
            if (indices.containsKey(difference)) {
                return new int[]{ indices.get(difference), i};
            } else {
                indices.put(num, i);
            }
        }

        return null;
    }
}
