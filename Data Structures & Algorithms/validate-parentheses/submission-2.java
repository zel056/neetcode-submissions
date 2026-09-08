class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();

        for (int i =0; i<s.length(); i++){
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            if (stack.isEmpty()){
                return false;
            }
            if (s.charAt(i)==')'){
                if (stack.peek().equals('(')){
                    stack.pop();
                    continue;
                }
                else{
                    return false;
                }
            }
            else if (s.charAt(i)==']'){
                if (stack.peek().equals('[')){
                    stack.pop();
                    continue;
                }
                else{
                    return false;
                }
            }

            else if (s.charAt(i)=='}'){
                if (stack.peek().equals('{')){
                    stack.pop();
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
