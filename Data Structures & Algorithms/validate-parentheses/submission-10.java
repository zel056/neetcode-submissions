class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<>();

        for(int i=0; i<s.length();i++){
            char chars = s.charAt(i);

            if (chars=='('||chars=='{'||chars=='['){
                stack.push(chars);
            }

            else{
                if (chars==')'){
                    if (stack.isEmpty()||stack.peek()!='('){
                        return false;
                    }
                    else{
                        stack.pop();
                    }
                }

                if (chars==']'){
                    if (stack.isEmpty()||stack.peek()!='['){
                        return false;
                    }
                    else{
                        stack.pop();
                    }
                }

                if (chars=='}'){
                    if (stack.isEmpty()||stack.peek()!='{'){
                        return false;
                    }
                    else{
                        stack.pop();
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
