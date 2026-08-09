class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPerm = new ArrayList<>();
        backtrack(nums, new ArrayList<Integer>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> currentPerm, List<List<Integer>> result) {
        // base case
        if (currentPerm.size() == nums.length) {
            // copy to avoid passing currentPerm (concurrent modifiction)
            result.add(new ArrayList<>(currentPerm));
            return;
        }

        // loop through nums
        for (int num : nums) {
            if (!currentPerm.contains(num)) {
                currentPerm.add(num);
                // recurse
                backtrack(nums, currentPerm, result);
                // pop last num (backtrack)
                currentPerm.remove(currentPerm.size() - 1);
            }
        }
    }
}
