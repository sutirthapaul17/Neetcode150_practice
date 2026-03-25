package Arrays;

public class Anagram {
//    public static boolean isAnagram(String s, String t) {
//        if(s.length()!= t.length()) return false;
//
//        int[] count = new int[26];
//        char[] sArray=s.toCharArray();
//        char[] tArray = t.toCharArray();
//        for(int i=0;i<s.length();i++){
//            count[sArray[i]-'a']++;
//        }
//        for(int i=0;i<s.length();i++){
//            count[tArray[i]-'a']--;
//        }
//        for(int i=0;i<26;i++){
//            if(count[i]>0){
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()) return false;

        int[] count = new int[26];

        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(count[i]>0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="jar";
        String t="jam";
        boolean ans = isAnagram(s,t);

    }
}
