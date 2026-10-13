class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        if (prices.length == 1) return max;

        int left = 0;
        int right = 1;
        
        while (left < right && right < prices.length) {
            max = Math.max(prices[right] - prices[left], max);
            
            while (prices[left] > prices[right]) left ++;

            right ++;
        }

        return max < 0 ? 0 : max; 
    }
}
