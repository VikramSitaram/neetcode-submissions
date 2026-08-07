public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Start from full target, index 0, and an empty path
        backtrack(target, 0, new ArrayList<>(), candidates, result);
        return result;
    }

    private void backtrack(int remaining, int start, List<Integer> path, 
                           int[] candidates, List<List<Integer>> result) {
        // Base case: if remaining is 0, we found a valid combination
        if (remaining == 0) {
            result.add(new ArrayList<>(path)); // Make a copy of the path
            return;
        } 
        // Base case: if remaining is negative, this path exceeds the target
        else if (remaining < 0) {
            return;
        }

        // Loop through candidates starting from the 'start' index to avoid duplicates
        for (int i = start; i < candidates.length; i++) {
            // Push the candidate into our current path
            path.add(candidates[i]);

            // Recursively explore further combinations with the updated path
            // Note: 'i' is passed as the next start index so we can reuse the same number
            backtrack(remaining - candidates[i], i, path, candidates, result);

            // Pop the candidate out of the path (Backtrack)
            path.remove(path.size() - 1);
        }
    }
}
