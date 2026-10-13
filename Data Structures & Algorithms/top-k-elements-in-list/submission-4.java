class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int count = 0;

        for (int i = freq.length - 1; i > 0 && count < k; i --) {
            if (!freq[i].isEmpty()) {
                for (Integer num : freq[i]) {
                    res[count] = num;
                    count ++;

                    if (count == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}
