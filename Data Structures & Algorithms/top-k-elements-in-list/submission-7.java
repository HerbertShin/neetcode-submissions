class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<List<Integer>> freqArr = new ArrayList<>();
        int[] res = new int[k];

        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            freqArr.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freqArr.get(entry.getValue()).add(entry.getKey());
        }

        int count = 0;

        for (int i = freqArr.size() - 1; i >= 0 && count < k; i --) {
            for (int num : freqArr.get(i)) {
                if (count == k) break;

                res[count ++] = num;
            }
        }

        return res;
    }
}
