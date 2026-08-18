class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod =1;
        int cnt=0;
        int[] result = new int [nums.length];
        for (int i=0; i<nums.length; i++){
            if (nums[i]==0){
                cnt++;
            }
            else{
                prod*= nums[i];
            }
        }

        if (cnt>1){
            return result;
        }

        for (int i =0; i<nums.length; i++){
            if (cnt>0){
                if (nums[i]==0){
                    result[i] = prod;
                }
            }
            else{
                result[i]=prod/nums[i];
            }
        }

        return result;
    }
}  
