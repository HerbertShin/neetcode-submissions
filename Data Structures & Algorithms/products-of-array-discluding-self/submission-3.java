class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        prefix[0] = 1;
        suffix[n - 1] = 1;

        for (int i = 1; i < n; i ++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
            suffix[n - i - 1] = nums[n - i] * suffix[n - i];
        }

        for (int i = 0; i < n; i ++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}  
