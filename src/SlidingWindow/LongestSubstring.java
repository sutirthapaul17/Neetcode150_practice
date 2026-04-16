package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
//    public int lengthOfLongestSubstring(String s) {
//        Set<Character> set = new HashSet<>();
//        int i = 0;
//        int j = i+1;
//        int maxLen = 0;
//        while(j<s.length()){
//            if(s.charAt(i) == s.charAt(j)){
//                maxLen = Math.max(maxLen, j - i);
//                i = i + 1;
//                j = i + 1;
//            }
//            j++;
//        }
//        return maxLen;
//    }


    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = i+1;
        int maxLen = 0;
        while(j<s.length()){
            if(set.contains(s.charAt(j))){
                maxLen = Math.max(maxLen, j - 1 - i);
                i = i + 1;
                j = i + 1;
                for(int k = i;k<j;k++){

                }
            }
            set.add(s.charAt(j));
            j++;
        }
        return maxLen;
    }
}
