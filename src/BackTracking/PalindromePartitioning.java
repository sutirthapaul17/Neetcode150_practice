package BackTracking;

import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        createPartition(0,ans,s,new ArrayList<>());
        return ans;
    }
    private void createPartition(
            int start, List<List<String>> ans, String s, List<String> a
    ){
        if(start == s.length()){
            ans.add(new ArrayList<>(a));
            return;
        }


        for(int end = start;end<s.length();end++){

            if(isPalindrome(s,start,end)){
                a.add(s.substring(start,end+1));
                createPartition(end+1,ans,s,a);
                a.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s,int left,int right){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;

    }
}
