class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //base case
        if (nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }

        // recurse
        int[] subNums = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            subNums[i-1] = nums[i];
        }
        List<List<Integer>> perms = permute(subNums);

        // build list
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> p : perms) {
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> pCopy = new ArrayList<>(p);
                pCopy.add(i, nums[0]);
                res.add(pCopy);
            }
        }

        return res;
    }
}
