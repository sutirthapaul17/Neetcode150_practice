package Stack;

import java.util.Objects;
import java.util.Stack;

public class EvaluateReversePolishNotation {
//    tokens = ["1","2","+","3","*","4","-"]
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int top = st.pop();
                    int bottom = st.pop();
                    st.push(bottom + top);
                }
                case "-" -> {
                    int top = st.pop();
                    int bottom = st.pop();
                    st.push(bottom - top);
                }
                case "*" -> {
                    int top = st.pop();
                    int bottom = st.pop();
                    st.push(bottom * top);
                }
                case "/" -> {
                    int top = st.pop();
                    int bottom = st.pop();
                    st.push(bottom / top);
                }
                case null, default -> {
                    assert token != null;
                    st.push(Integer.valueOf(token));
                }
            }
        }
        return st.peek();
    }
}
