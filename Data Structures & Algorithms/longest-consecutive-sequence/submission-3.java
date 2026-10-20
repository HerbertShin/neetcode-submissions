class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>(); 
        int max = 0;
        
        for (int num : nums) {
            uniqueNums.add(num);
        }

        for (Integer num : uniqueNums) {
            if (uniqueNums.contains(num - 1)) continue;

            int count = 0; 

            while (uniqueNums.contains(num)) {
                count ++;
                num ++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}
