class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int totalProfit = 0;

        for (int i = 1; i < len ; i++) {
            if(prices[i]>prices[i-1]) {
                totalProfit = totalProfit + prices[i] - prices[i-1];
            }
        }

        return totalProfit;
    }
}