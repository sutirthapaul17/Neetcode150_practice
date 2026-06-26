package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LogestRepeatingCharact {

    //Brute force   -> TLE on leetcode   => O(n^2)
//    public int characterReplacement(String s, int k) {
//        int res = 0;
//        for(int i = 0;i<s.length();i++){
//            Map<Character,Integer> map = new HashMap<>();
//            int maxf = 0;
//            for(int j = i;j<s.length();j++){
//                int windowLen = j - i + 1;
//                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
//                maxf = Math.max(maxf,map.get(s.charAt(j)));
//                if(windowLen - maxf <= k) res = Math.max(res,windowLen);
//            }
//        }
//        return res;
//    }


    //Method - 2 (using hashset)
//    public int characterReplacement(String s, int k) {
//        int res = 0;
//        Set<Character> charSet = new HashSet<>();
//        for(char c : s.toCharArray()){
//            charSet.add(c);
//        }
//        for(char ch : charSet){
//            int l = 0;
//            int count = 0;
//            for(int r = 0;r<s.length();r++){
//                if(s.charAt(r) == ch){
//                    count++;
//                }
////                int numberOfCharacterToBeReplaced = windowLen - count;
//                while(r - l + 1 - count > k){   //windowLen = r - l + 1;
//                    if(s.charAt(l) == ch){
//                        count--;
//                    }
//                    l++;
//                }
//                res = Math.max(res,r - l + 1);
//            }
//        }
//        return res;
//    }


    //Method - 3 (freq array)
    public int characterReplacement(String s, int k) {
        int res = 0;
        int[] freq = new int[26];

        int l = 0;
        int maxFreq = 0;
        for(int r = 0;r<s.length();r++){
            char ch = s.charAt(r);
            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq,freq[ch-'A']);
            while(r - l + 1 - maxFreq > k){   //windowLen = r - l + 1;
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}
