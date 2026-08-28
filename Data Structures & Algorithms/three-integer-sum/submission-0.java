class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num1 = nums[i];
            int subtarget = 0-num1;
            int head = i+1;
            int tail =nums.length-1;
            while (head<tail){
                if (subtarget-nums[head]<nums[tail]){
                    tail--;
                }
                else if(subtarget-nums[tail]>nums[head]){
                    head++;
                }
                else{
                    result.add(new ArrayList<>(Arrays.asList(nums[i],nums[head],nums[tail])));
                    head++;
                    tail--;

                    while (head < tail && nums[head] == nums[head - 1]) {
                        head++;
                    }
                    while (head < tail && nums[tail] == nums[tail + 1]) {
                        tail--;
                    }
                }
            }
        }
        return result;
    }
}
