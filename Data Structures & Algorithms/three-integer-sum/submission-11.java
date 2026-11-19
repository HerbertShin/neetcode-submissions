class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int l = 0; l < nums.length; l ++) {
            if (l > 0 && nums[l] == nums[l - 1]) continue;

            int r = nums.length - 1;
            int m = l + 1;

            while (m < r) {
                
                int sum = nums[l] + nums[r] + nums[m];

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
