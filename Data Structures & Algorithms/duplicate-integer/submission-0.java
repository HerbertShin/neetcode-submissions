class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false; 

        Set<Integer> foundNums = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (foundNums.contains(num)) {
                return true;
            }

            foundNums.add(num);
        }

        return false; 
    }
}