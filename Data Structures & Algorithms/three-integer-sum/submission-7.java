class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);

        for (int l = 0; l < nums.length; l ++) {
            int m = l + 1, r = nums.length - 1;

            if (nums[l] > 0) break;
            if (l > 0 && nums[l] == nums[l - 1]) continue;

            while (m < r) {
                int sum = nums[l] + nums[m] + nums[r];

                if (sum == 0) {
                    result.add(new ArrayList<>(List.of(nums[l], nums[m], nums[r])));
                    m ++;
                    r --;

                    while (m < r && nums[m] == nums[m - 1]) {
                        m ++;
                    }
                } else if (sum > 0) {
                    r --;
                } else {
                    m ++;
                }
            }
        }

        return result;
    }
}
