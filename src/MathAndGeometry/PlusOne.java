package MathAndGeometry;

public class PlusOne {

//    public int[] plusOne(int[] digits) {
//        int i = digits.length-1;
//        int carry = 1;
//        while(i>=0){
//            digits[i] = digits[i] + (carry--);
//            if(digits[i] == 10){
//                digits[i] = 0;
//                carry = 1;
//                i--;
//            }else{
//                break;
//            }
//        }
//        if(carry == 1){
//            int[] ans = new int[digits.length+1];
//            ans[0] = carry;
//            for(int j=1;j<ans.length;j++){
//                ans[j] = digits[j-1];
//            }
//            return ans;
//        }
//
//        return digits;
//    }


    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }

        int[] ans = new int[n+1];
        ans[0] = 1;

        return ans;
    }
}
