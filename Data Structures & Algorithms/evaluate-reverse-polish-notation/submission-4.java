class Solution {
    public int evalRPN(String[] tokens) {
        int result =0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<tokens.length;i++){
            String curr = tokens[i];
            if (curr.equals("+")){
                result = stack.pop()+stack.pop();
                stack.push(result);
            }
            else if(curr.equals("-")){
                int diff = stack.pop();
                result = stack.pop() - diff;
                stack.push(result);
            }
            else if(curr.equals("*")){
                result=stack.pop()*stack.pop();
                stack.push(result);
            }
            else if (curr.equals("/")){
                int divisor = stack.pop();
                result= stack.pop()/divisor;
                stack.push(result);
            }
            else{
                int num = Integer.parseInt(curr);
                stack.push(num);
            }

        }
        return stack.peek();
    }
}
