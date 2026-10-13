class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> existingSet = new HashSet<>();
        
        for (int num : nums) {
            if (existingSet.contains(num)) {
                return true;
            } else {
                existingSet.add(num);
            }
        }

        return false;
    }
}