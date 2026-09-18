class Solution {
    public int search(int[] nums, int target) {
        int head =0;
        int tail = nums.length-1;

        int result =-1;

        while (head<=tail){
            int medium = head+(tail-head)/2;

            if (nums[medium]==target){
                return medium;
            }

            if (nums[head]<=nums[medium]){
                if (target>=nums[head]&&target<=nums[medium]){
                    tail = medium-1;
                }
                else {
                    head = medium+1;
                }
            }
            else{
                if (target > nums[medium] && target <= nums[tail]) {
                        head = medium + 1;
                    } 
                    else {
                        tail = medium - 1;
                    }
            }
        }
        return -1;
    }
}
