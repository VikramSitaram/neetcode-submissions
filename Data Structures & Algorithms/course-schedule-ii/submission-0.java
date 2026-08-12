class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        for (int[] prereqs : prerequisites) {
            if (prereqMap.get(prereqs[0]) == null) {
                prereqMap.put(prereqs[0], new ArrayList<>());
            }
            prereqMap.get(prereqs[0]).add(prereqs[1]);
        }

        // output list (will convert to array at end)
        List<Integer> output = new ArrayList<>();

        // create visit and cycle sets
        Set<Integer> visitSet = new HashSet<>();
        Set<Integer> cycleSet = new HashSet<>();

        // run dfs on each course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, prereqMap, visitSet, cycleSet, output)) {
                return new int[0];
            }
        }

        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereqMap, Set<Integer> visitSet, Set<Integer> cycleSet, List<Integer> output) {
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

        // run dfs on each prereq to detect cycle
        for (int prereq : prereqMap.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(prereq, prereqMap, visitSet, cycleSet, output)) {
                return false;
            }
        }

        // remove from cycleSet and add to visitSet / output
        cycleSet.remove(course);
        visitSet.add(course);
        output.add(course);

        return true;
    }
}
