class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);
        int best = 0; 

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = 1;

                while(set.contains(num + 1)) {
                    curr ++;
                    num ++;
                }

                best = Math.max(best, curr);
            }
        }

        return best; 
    }
}
