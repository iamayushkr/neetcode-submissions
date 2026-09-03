class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0; // The index of our lowest buy price
        int maxProfit = 0;

        for (int sell = 1; sell < prices.length; sell++) {
            if (prices[sell] < prices[buy]) {
                // We found a cheaper day to buy, so snap the pointer here
                buy = sell;
            } else {
                // Calculate the profit for our current window
                int currentProfit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        
        return maxProfit;
    }
}