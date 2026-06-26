package SlidingWindow;

public class MinimumWindowSubstring {

    //Brute force -> 0(n)
//    public String minWindow(String s, String t) {
//        int minLen = Integer.MAX_VALUE;
//        String ans = "";
//
//        for(int i=0;i<s.length();i++){
//            int[] freq = new int[128];
//
//            for(char ch : t.toCharArray()){
//                freq[ch]++;
//            }
//
//            int remaining = t.length();
//            for(int j = i; j<s.length();j++){
//                char ch = s.charAt(j);
//
//                if(freq[ch]>0){
//                    remaining--;
//                }
//                freq[ch]--;
//
//                if(remaining==0){
//                    if(j-i+1 < minLen){
//                        minLen = j - i + 1;
//                        ans=s.substring(i,j+1);
//                    }
//                    break;
//                }
//            }
//        }
//        return ans;
//    }

    //Sliding window -> 0(n)
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        int[] count = new int[128];
        for(char ch:t.toCharArray()){
            count[ch]++;
        }

        int left=0;
        int start=0;

        int minLen = Integer.MAX_VALUE;
        int remaining = t.length();

        for (int right = 0; right < s.length();right++){
            char ch = s.charAt(right);
            if(count[ch]>0){
                remaining--;
            }
            count[ch]--;
            while(remaining == 0){
                if(right - left + 1 < minLen){
                    minLen = right -left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                count[leftChar]++;
                if(count[leftChar] > 0){
                    remaining++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "":s.substring(start,start+minLen);
    }

}
