class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0, j = numbers.length - 1;

        while (numbers[i] + numbers[j] != target && i < j) {
            while (numbers[i] + numbers[j] < target && i < j) i++;
            while (numbers[i] + numbers[j] > target && i < j) j--;
        }
        
        result[0] = convertZeroIndexed(i);
        result[1] = convertZeroIndexed(j);

        return result; 
    }

    private int convertZeroIndexed(int index) {
        if (index == 0) return 1;

        return index + 1;
    }
}
