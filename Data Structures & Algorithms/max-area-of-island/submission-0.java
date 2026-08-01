class Solution {
    Set<String> visited = new HashSet<>();

    private int dfs(int[][] grid, int r, int c) {
        // base checks
        if(r < 0 || r >= grid.length
            || c < 0 || c >= grid[0].length
            || visited.contains(r + "#" + c)
            || grid[r][c] == 0) {
                return 0;
            }

            // mark cell as visited
            visited.add(r + "#" + c);

            // recurse and return sum (add +1 for itself)
            return dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1) + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        // look at each cell
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // check if island
                if (grid[r][c] == 1 && !visited.contains(r + "#" + c)) {
                    // run dfs starting from this cell
                    int area = dfs(grid, r, c);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }
}
