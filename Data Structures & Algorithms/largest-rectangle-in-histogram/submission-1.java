class Solution {
    public int largestRectangleArea(int[] heights) {
        //two pointer at first
        //Stack: >= the stack top should just continue

        Stack<Integer> stack = new Stack<>();

        int[] minL = new int[heights.length];
        int[] minR = new int[heights.length];

        

        for (int i=0; i<heights.length;i++){
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            minL[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i=heights.length-1;i>=0;i--){
            while (!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            minR[i] = stack.isEmpty()?heights.length:stack.peek();
            stack.push(i);
        }

        int maxArea =0;
        for (int i=0; i<minL.length;i++){
            int width = minR[i]-minL[i]-1;
            int area = heights[i]*width;
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;


    }
}
