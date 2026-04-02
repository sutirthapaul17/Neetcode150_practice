package TwoPointer;



public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] charArr = str.toCharArray();
        int i=0,j=charArr.length-1;
        while(i<=j){
            if(charArr[i] != charArr[j]){
                System.out.println("i:"+i+"j:"+j);
                System.out.println("char at i:"+charArr[i]+" ,char at j:"+charArr[j]);
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
