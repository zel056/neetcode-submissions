class Solution {
    public int maxProfit(int[] prices) {
        int max =0;
        int min = prices[0];
        for (int i=0;i<prices.length;i++){
            int sell = prices[i];

            min = Math.min(min,sell);

            int profit = sell - min;

            max = Math.max(max,profit);
        }

        return max;
    }
}
