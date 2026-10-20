class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> bounds = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            if (bounds.containsKey(num)) continue;

            int left = bounds.getOrDefault(num - 1, 0);
            int right = bounds.getOrDefault(num + 1, 0);
            
            int length = left + 1 + right;

            bounds.put(num, length);
            bounds.put(num - left, length);
            bounds.put(num + right, length);

            max = Math.max(max, length);
        }

        return max; 
    }
}
