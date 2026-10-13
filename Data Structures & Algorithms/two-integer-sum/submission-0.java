class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>();
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (diffMap.containsKey(target - nums[i])) {
                index = i;
                break;
            }

            diffMap.put(nums[i], i);
        }

        return new int[]{diffMap.get(target - nums[index]), index};
    }
}
