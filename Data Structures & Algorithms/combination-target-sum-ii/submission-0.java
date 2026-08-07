class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort array (this helps us eliminate duplicates)
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(target, 0, new ArrayList<>(), candidates, result);
        return result;
    }

    private void backtrack(int remaining, int start, List<Integer> path, int[] candidates, List<List<Integer>> result) {
        // base cases
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (remaining < 0) { return; }

        // loop through candidates
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            // start from the next index to avoid reuse of same element
            backtrack(remaining - candidates[i], i + 1, path, candidates, result);
            path.remove(path.size() - 1);
        }
    }
}
