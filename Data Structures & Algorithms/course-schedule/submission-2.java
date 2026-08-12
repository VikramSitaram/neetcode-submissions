class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        for (int[] prereqs : prerequisites) {
            if (prereqMap.get(prereqs[0]) == null) {
                prereqMap.put(prereqs[0], new ArrayList<>());
            }
            prereqMap.get(prereqs[0]).add(prereqs[1]);
        }

        // create visit and cycle sets
        Set<Integer> visitSet = new HashSet<>();
        Set<Integer> cycleSet = new HashSet<>();

        // run dfs on each course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, prereqMap, visitSet, cycleSet)) {
                return false; // Cycle detected, cannot finish
            }
        }

        return true; // No cycles found, can finish
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereqMap, Set<Integer> visitSet, Set<Integer> cycleSet) {
        // base case 1: check if present in cycleSet
        if (cycleSet.contains(course)) {
            return false;
        }

        // base case 2: check if present in visitSet
        if (visitSet.contains(course)) {
            return true;
        }

        // add to cycleSet
        cycleSet.add(course);

        // Use getOrDefault to prevent NullPointerException
        for (int prereq : prereqMap.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(prereq, prereqMap, visitSet, cycleSet)) {
                return false;
            }
        }

        // remove from cycleSet and add to visitSet
        cycleSet.remove(course);
        visitSet.add(course);

        return true;
    }
}
