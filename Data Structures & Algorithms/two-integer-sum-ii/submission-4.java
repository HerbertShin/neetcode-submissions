class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int l = 0;
        int r = numbers.length - 1;

        while (l < r && numbers[l] + numbers[r] != target) {
            while (numbers[l] + numbers[r] < target) {
                l ++;
            }

            while (numbers[l] + numbers[r] > target) {
                r --;
            }
        }

        result[0] = l + 1;
        result[1] = r + 1;

        return result;
    }
}
