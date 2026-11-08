class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        int[] res = new int[nums.length - k + 1];
        int count = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            pq.add(new int[]{nums[i], i});

            if (i >= k - 1) {
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }

                res[count ++] = pq.peek()[0];
            }
        }

        return res;
    }
}
