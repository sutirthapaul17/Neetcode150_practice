package SlidingWindow;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PermutationInAString {

    //Brute force + sort
//    public boolean checkInclusion(String s1, String s2) {
//        char[] arr = s1.toCharArray();
//        Arrays.sort(arr);
//        String target = new String(arr);
//
//        int k = s1.length();
//
//        for(int i = 0;i<=s2.length()-k;i++){
//            String sub = s2.substring(i,i+k);
//
//            char[] temp = sub.toCharArray();
//            Arrays.sort(temp);
//
//            if(target.equalsIgnoreCase(new String(temp))){
//                return true;
//            }
//        }
//        return false;
//    }





    //Optimised -> O(26n)
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for(int i = 0;i<s1.length();i++){
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }
        if(matches(s1Count,windowCount)){
            return true;
        }

        for(int i = s1.length();i<s2.length();i++){
            windowCount[s2.charAt(i) - 'a']++;//add new char
            windowCount[s2.charAt(i-s1.length()) - 'a']--;//remove old char

            if(matches(s1Count,windowCount)){
                return true;
            }
        }

        return false;

    }

    boolean matches(int[] a,int[] b){
        for(int i=0;i<26;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}
