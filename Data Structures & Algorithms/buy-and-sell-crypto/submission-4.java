class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxP = 0;
        while(sell<prices.length){
            if (prices[buy]<prices[sell]){
                maxP = Math.max(maxP,prices[sell]-prices[buy]);
            }
            else{
                buy = sell;
            }
            sell++;
        }

        return maxP;
    }
}
