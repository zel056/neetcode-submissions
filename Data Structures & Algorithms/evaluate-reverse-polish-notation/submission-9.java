class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans =0;

        for (int i=0; i<tokens.length;i++){
            String s = tokens[i];
            if (s.equals("+")){
                ans = stack.pop()+stack.pop();
                stack.push(ans);
            }
            else if (s.equals("*")){
                ans = stack.pop()*stack.pop();
                stack.push(ans);
            }
            else if (s.equals("/")){
                int divisor = stack.pop();
                ans = stack.pop()/divisor;
                stack.push(ans);
            }
            else if (s.equals("-")){
                int sec = stack.pop();
                ans = stack.pop()-sec;
                stack.push(ans);
            }

            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
