class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int i = 0; i < nums.length + 1; i ++) {
            bucket[i] = new ArrayList<>();
        }

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0; i--) {
            for (int num : bucket[i]) {
                result[index] = num;
                index ++;

                if (index == k) return result;
            }
        }

        return result;
    }
}
