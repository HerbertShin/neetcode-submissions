class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;

        while (numbers[i] + numbers[j] != target && i < j) {
            while (numbers[i] + numbers[j] < target && i < j) i++;
            while (numbers[i] + numbers[j] > target && i < j) j--;
        }
        
        return new int[]{convertZeroIndexed(i), convertZeroIndexed(j)};
    }

    private int convertZeroIndexed(int index) {
        return index + 1;
    }
}
