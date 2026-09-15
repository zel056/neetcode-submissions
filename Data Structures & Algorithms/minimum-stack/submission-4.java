class MinStack {
    Stack<Integer> norm;
    Stack<Integer> min;
    public MinStack() {
        norm = new Stack<>();

        min = new Stack<>();
    }
    
    public void push(int val) {
        norm.push(val);
        if (min.isEmpty()||val<min.peek()){
            min.push(val);
        }
        else{
            min.push(min.peek());
        }
        
    }
    
    public void pop() {
        norm.pop();
        min.pop();
        
    }
    
    public int top() {
        return norm.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
