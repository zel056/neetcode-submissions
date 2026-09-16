class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] lessLeft = new int[heights.length];
        int[] lessRight = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<heights.length;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            lessLeft[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i=heights.length-1; i>=0;i--){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            lessRight[i] = stack.isEmpty()?heights.length:stack.peek();
            stack.push(i);
        }

        int maxArea =0;
        for (int i=0; i<heights.length;i++){
            int width = lessRight[i]-lessLeft[i]-1;
            int area = heights[i]*width;
            maxArea = Math.max(maxArea,area);
        }

        return maxArea;

    }
}
