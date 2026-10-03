class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0 ; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                //Find max in rest of array
                int max = prices[j];
                for (int z = j; z < prices.length; z++) {
                    if (prices[z] > max) {
                        max = prices[z];
                    }
                }
                int localMaxProfit = max - prices[i];
                if (localMaxProfit > maxProfit) {
                    maxProfit = localMaxProfit;
                }
            }
        }
        return maxProfit;
    }
}
