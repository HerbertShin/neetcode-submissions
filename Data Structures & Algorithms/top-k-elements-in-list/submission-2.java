class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        
        for (int i = 0; i < freq.length; i ++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int pos = 0;

        for (int i = freq.length - 1; i > 0 && pos < k; i--) {
            for (int num : freq[i]) {
                result[pos++] = num;

                if (pos == k) return result;
            }
        }

        return result; 
    }
}
