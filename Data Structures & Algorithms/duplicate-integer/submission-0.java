class Solution {
    public boolean hasDuplicate(int[] nums) {
        //Key: the number;  value: the index
        Hashtable<Integer,Integer> map = new Hashtable();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            else{
                return true;
            }
        }
        return false;
    }
}