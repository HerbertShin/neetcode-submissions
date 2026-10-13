class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int max = 0;

        if (nums.length == 0) return 0;

        for (int num : nums) {
            set.add(num);
        }

        for (Integer num : set) {
            int count = 0;

            if (!set.contains(num - 1)) {
                int curr = num;
                
                while (set.contains(curr ++)) {
                    count ++;
                }
            }
            
            max = Math.max(max, count);
        }

        return max;
    }
}
