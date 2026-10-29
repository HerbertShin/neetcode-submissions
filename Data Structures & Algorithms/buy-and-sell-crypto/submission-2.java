class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = l + 1;
        int maxProfit = 0;
        
        while (r < prices.length) {
            maxProfit = Math.max(prices[r] - prices[l], maxProfit);

            if (prices[r] < prices[l]) {
                l = r;
            }
            
            r ++;
        }

        return maxProfit;
    }
}
