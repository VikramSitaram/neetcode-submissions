class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{0,1};
        }

        Map<Integer, Integer> valueIndices = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int difference = target - nums[i];
            if (valueIndices.containsKey(difference)) {
                return new int[]{valueIndices.get(difference), i};
            } else {
                valueIndices.put(nums[i], i);
            }
        }

        return null;
    }
}
