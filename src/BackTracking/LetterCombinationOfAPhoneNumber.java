package BackTracking;

import java.util.*;

public class LetterCombinationOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] phone = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };
        StringBuilder sb = new StringBuilder();
        buildCombo(0,ans,digits,sb,phone);
        return ans;
    }
    private void buildCombo(int idx,
                            List<String> ans, String digits, StringBuilder sb, String[] phone){

        if(idx==digits.length()){
            ans.add(new String(sb));
            return;
        }
        char digit = digits.charAt(idx);
        int num = digit - '0';
        String letters = phone[num];
        for(int j=0;j<letters.length();j++){
            //choose
            sb.append(letters.charAt(j));
            //recursion
            buildCombo(idx+1,ans,digits,sb,phone);
            //backtrack
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
