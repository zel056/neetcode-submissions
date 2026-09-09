class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack();
        min = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
        if (min.isEmpty()){
            min.push(val);
        }
        else{
            if (min.peek().compareTo(val)>=0){
                min.push(val);
            }
        }
        
    }
    
    public void pop() {
        if (stack.peek().equals(min.peek())){
            min.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
