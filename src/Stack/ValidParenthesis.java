package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    //Method-1(normal stack)
//    public boolean isValid(String s) {
//        Stack<Character> st = new Stack<>();
//        for(char ch : s.toCharArray()){
//            if((ch=='(') || (ch == '[') || (ch=='{')){
//                st.push(ch);
//            }else if((!st.isEmpty()) &&(ch == ')') && st.peek()=='('){
//                st.pop();
//            }else if((!st.isEmpty()) && (ch == '}') && st.peek()=='{'){
//                st.pop();
//            }else if((!st.isEmpty()) && (ch == ']') && st.peek()=='['){
//                st.pop();
//            }else{
//                return false;
//            }
//        }
//        return st.isEmpty();
//    }

    //Method-II(Map and stack)
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(char ch : s.toCharArray()){
            if((ch=='(') || (ch == '[') || (ch=='{')){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.peek();
                if(top == map.get(ch)) st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }
}
