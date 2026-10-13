class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int i = 0, j = 1;

        while (j < prices.length) {
            max = Math.max(prices[j] - prices[i], max);

            if (prices[j] < prices[i]) {
                i = j;
            }

            j++;
        }

        return max;
    }
}
