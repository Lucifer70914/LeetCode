class MinStack {
    Stack<Long> st=new Stack<>();
    long min=-1;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.size()==0)
        {
            st.push((long)val);
            min=val;
        }
        else if(val>=min)
        {
            st.push((long)val);
        }
        else
        {
            st.push(2L*val-min);
            min=val;
        }
        
    }
    
    public void pop() {
        if(st.size()==0) return;
        else if(st.peek()>=min)
        st.pop();
        else
        {
            min=(2*min-st.peek());
            st.pop();
        }
        
    }
    
    public int top() {
        if(st.peek()>=min)
        return (int)(long)st.peek();
        else
        return (int)min;
        
    }
    
    public int getMin() {
        return (int)min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */