class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int header =0;
        int tail = numbers.length-1;
        while (header!=tail){
            if (target-numbers[header]<numbers[tail]){
                tail--;
            }
            else if (target-numbers[tail]>numbers[header]){
                header++;
            }
            else{
                break;
            }
        }

        return new int[]{header+1,tail+1};
    }
}
