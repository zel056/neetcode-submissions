class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int[] suff = new int[nums.length];

        int n = nums.length;
        result[0] = 1;
        suff[n-1]=1;

        for(int i=1; i<n; i++){
            result[i] = result[i-1]*nums[i-1];
        }

        int right =1;
        for (int i = n-1; i>=0; i--){
            result[i] *= right;
            right *= nums[i];
        }

        return result;

    }
}  
