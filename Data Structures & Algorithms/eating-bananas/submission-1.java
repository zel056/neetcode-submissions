class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int maxSpd = piles[piles.length-1];
        int head =1;
        int result=0;

        while (head<=maxSpd){
            int k = head+(maxSpd-head)/2;
            int header =0;
            int tail = piles.length-1;
            int temp =0;
            while (header<=tail){
                if (header == tail) {
                    temp += (piles[header] + k - 1) / k;
                }
                else {
                    temp += (piles[header] + k - 1) / k;
                    temp += (piles[tail] + k - 1) / k;
                }
                header++;
                tail--;
            }
            if (temp<=h){
                result =k;
                maxSpd=k-1;
            }
            else {
                head = k+1;
            }
        }
        return result;
    }
}
