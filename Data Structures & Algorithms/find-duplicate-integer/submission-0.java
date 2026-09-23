class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = -1;

        for (int i =0; i<nums.length; i++){
            if (map.containsKey(nums[i])){
                result = nums[i];
            }
            else{
                map.put(nums[i],i);
            }
        }

        return result;
    }
}
