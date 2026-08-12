class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        for (int[] prereqs : prerequisites) {
            if (prereqMap.get(prereqs[0]) == null) {
                prereqMap.put(prereqs[0], new ArrayList<>());
            }
            prereqMap.get(prereqs[0]).add(prereqs[1]);
        }

        // set of visited courses
        Set<Integer> visited = new HashSet<>();
        
        // check each course for cycles
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, prereqMap, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereqMap, Set<Integer> visited) {
        // base case 1: course is already present - cycle found
        if (visited.contains(course)) {
            return false;
        }

        // base case 2: course has no prereq - return true
        if (prereqMap.get(course) == null) {
            return true;
        }

        // add course
        visited.add(course);

        // recurse through prereq
        for (int prereq : prereqMap.get(course)) {
            if (!dfs(prereq, prereqMap, visited)) {
                return false;
            }
        }

        // remove from visited
        visited.remove(course);

        // set prereqMap to empty for this course
        prereqMap.remove(course);

        return true;
    }
}
