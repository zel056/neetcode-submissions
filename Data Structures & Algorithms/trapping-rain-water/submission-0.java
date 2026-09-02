class Solution {
    public int trap(int[] height) {
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];
        int[] min = new int[height.length];
        int result =0;

        for (int i =0; i<height.length; i++){
            if (i==0){
                maxL[i] = 0;
            }
            else{
                maxL[i] = Math.max(height[i-1],maxL[i-1]);
            }
        }

        for (int i = height.length-1;i>=0;i--){
            if (i==height.length-1){
                maxR[i] = 0;
            }
            else{
                maxR[i] = Math.max(height[i+1],maxR[i+1]);
            }
        }

        for (int i =0; i<min.length;i++){
            min[i] = Math.min(maxL[i],maxR[i]);
        }

        for (int i =0; i<height.length;i++){
            if (min[i]-height[i]>=0){
                result+=min[i]-height[i];
            }
        }
        return result;
    }
}
