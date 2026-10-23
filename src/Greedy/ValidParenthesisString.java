package Greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesisString {
    //Method - I
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lo++;
                hi++;
            } else if (c == ')') {
                lo--;
                hi--;
            } else { // '*'
                lo--; // treat as ')'
                hi++; // treat as '('
            }
            if (hi < 0)
                return false; // too many ')' even if every '*' is '('
            if (lo < 0)
                lo = 0; // can't have negative open count
        }
        return lo == 0;
    }

    //Mthod - II(Stack)
//    public boolean checkValidString(String s) {
//        Deque<Integer> open = new ArrayDeque<>();
//        Deque<Integer> star = new ArrayDeque<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                open.push(i);
//            } else if (c == '*') {
//                star.push(i);
//            } else { // ')'
//                if (!open.isEmpty())
//                    open.pop();
//                else if (!star.isEmpty())
//                    star.pop();
//                else
//                    return false;
//            }
//        }
//
//        while (!open.isEmpty() && !star.isEmpty()) {
//            if (open.pop() > star.pop())
//                return false; // '*' is before '(' -> can't close it
//        }
//
//        return open.isEmpty();
//    }
}
