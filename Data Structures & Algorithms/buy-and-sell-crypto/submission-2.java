class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxProfit = 0; 
        for ( ; sell < prices.length ; sell++) {
            if(prices[sell] < prices[buy]) {
                buy = sell;
            } else {
                int currentProfit = prices[sell] - prices[buy];
                maxProfit = Math.max(currentProfit, maxProfit);
            }
        }
        return maxProfit;
    }
}
