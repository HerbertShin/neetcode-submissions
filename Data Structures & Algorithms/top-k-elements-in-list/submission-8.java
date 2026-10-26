class Solution {
    public int[] topKFrequent(int[] nums, int k) {        
        List<List<Integer>> bucket = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] result = new int[k];

        for (int i = 0; i < nums.length; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

        freqMap.forEach((key, val) -> {
            bucket.get(val - 1).add(key);
        });

        int count = 0;

        for (int i = nums.length - 1; count < k; i--) {
            for (int num : bucket.get(i)) {
                if (count == k) break;

                result[count] = num;
                count ++;
            }
        }

        return result;
    }
}
