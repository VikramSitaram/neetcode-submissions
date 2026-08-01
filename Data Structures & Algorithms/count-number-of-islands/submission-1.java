class Solution {
    Set<String> visited = new HashSet<>();

    private void dfs (char[][] grid, int r, int c) {
        // base cases (boundary conditions + island check)
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // check if visited
        String visitedStr = r + "," + c;
        if (visited.contains(visitedStr)) {
            return;
        }

        // mark it visited
        visited.add(visitedStr);

        // check linear neighbors
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int numOfIslands = 0;

        // iterate through grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
                    numOfIslands++;
                    // call dfs to check neighbors
                    dfs(grid, r, c);
                }
            }
        }

        return numOfIslands;
    }
}
