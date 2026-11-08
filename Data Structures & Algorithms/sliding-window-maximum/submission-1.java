class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int l = 0, r = 0;
        int count = 0;
        int[] res = new int[nums.length - k + 1];

        while (r < k) {
            pq.add(nums[r ++]);
        }

        res[count ++] = pq.peek();

        while (r < nums.length) {
            if (nums[l] == pq.peek()) pq.poll();
            else pq.remove(nums[l]);
            
            pq.add(nums[r]);
            
            res[count ++] = pq.peek();

            l ++;
            r ++;
        }

        return res;
    }
}
