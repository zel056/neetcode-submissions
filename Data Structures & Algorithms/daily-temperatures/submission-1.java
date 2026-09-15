class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] temp = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<temperatures.length;i++){
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int prevTemp = stack.pop();
                temp[prevTemp] = i-prevTemp;
            }
            stack.push(i);
        }

        return temp;
    }
}
