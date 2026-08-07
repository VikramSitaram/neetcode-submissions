class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        // get frequencies
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // create buckets where index = frequency
        int n = nums.length;
        List<Integer>[] buckets = new List[n + 1];
        for (int num : counts.keySet()) {
            int numFreq = counts.get(num);
            if (buckets[numFreq] == null) {
                buckets[numFreq] = new ArrayList<>();
            }
            buckets[numFreq].add(num);
        }

        // get top k numbers
        List<Integer> result = new ArrayList<>();
        for (int i = n; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result.add(num);
                    int resultSize = result.size();
                    if (resultSize == k) {
                        int[] resultArr = new int[resultSize];
                        for (int j = 0; j < resultSize; j++) {
                            resultArr[j] = result.get(j);
                        }
                        return resultArr;
                        //return result.stream().mapToInt(Integer::intValue).toArray();
                    }
                }
            }
        }

        return null;
    }
}
