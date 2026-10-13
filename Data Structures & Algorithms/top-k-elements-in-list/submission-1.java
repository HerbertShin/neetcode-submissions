class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> bucket = new ArrayList<>(nums.length + 1);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }

        int[] ans = new int[Math.min(k, map.size())];

        int idx = 0;

        for (int i = nums.length; i >= 1 && idx < k; i--) {
                for (Integer val : bucket.get(i)) {
                    ans[idx++] = val;

                    if (idx == k) break;
                }
        }

        return ans; 
    }
}
