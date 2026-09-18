class Solution {
    public int findMin(int[] nums) {
        int head = 0;
        int tail = nums.length-1;
        int min = nums[head];

        while (head<tail){
            int medium = head+(tail-head)/2;

            if (nums[medium]<nums[head]){
                tail = medium;
            }
            else if (nums[medium]>nums[tail]){
                head = medium+1;
            }
            else if(nums[head]<nums[tail]){
                tail = medium;
            }
        }
        return nums[head];
    }
}
