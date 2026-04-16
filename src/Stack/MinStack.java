package Stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    public MinStack() {
         st = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        Stack<Integer> st2 = new Stack<>();
        while(!st.isEmpty()){
            min = Math.min(st.peek(),min);
            st2.push(st.pop());
        }
        while(!st2.isEmpty()){
            st.push(st2.peek());
        }
        return min;
    }
}
