class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;
        int j = 1;
        int k = nums.length - 1;

        Set<String> existingSums = new HashSet<>();

        while (i < k - 1) {
            if (nums[i] > 0) break;
            
            while (j < k) {
                int target = nums[i] + nums[j] + nums[k];
                String key = Integer.toString(nums[i]) + Integer.toString(nums[j]) + Integer.toString(nums[k]);

                if (target == 0 && !existingSums.contains(key)) {
                    List<Integer> validSum = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                    result.add(validSum);
                    existingSums.add(key);
                    k --;
                    j ++;
                } else if (target > 0) {
                    k --;
                } else {
                    j ++;
                }
            }

            i ++;
            j = i + 1;
            k = nums.length - 1;
        }

        return result;
    }
}
