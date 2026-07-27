class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // base case (or edge case for iteration)
        if (nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }

        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newPerms = new ArrayList<>();
            for (List<Integer> p : perms) {
                for (int i = 0; i <= p.size(); i++) {
                    List<Integer> pCopy = new ArrayList<Integer>(p);
                    pCopy.add(i, num);
                    newPerms.add(pCopy);
                }
            }
            perms = newPerms;
        }

        return perms;

        /* recurse
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
        */
    }
}
