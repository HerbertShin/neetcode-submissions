class Solution {
    public int[] twoSum(int[] numbers, int target) {        
        int[] result = new int[2];
        int l = 0; 
        int r = numbers.length - 1;

        while (l < r) {
            int numTwo = target - numbers[l];

            while (numbers[r] > numTwo) {
                r --;
            }

            if (numTwo == numbers[r]) {
                result[0] = l + 1;
                result[1] = r + 1;
                break;
            }

            l ++;
        }
        
        return result;
    }
}
