package BitManipulation;

public class NumberOfOneBits {
    // convert to binary, count 1's -> O(logn)
//    private void convertToBinary(int n,StringBuffer binary){
//        if((n == 1) || (n == 0)){
//            binary.append(n);
//            return;
//        }
//        int remaining  = n%2;
//        n /= 2;
//        convertToBinary(n,binary);
//        binary.append(remaining);
//    }
//
//    public int hammingWeight(int n) {
//        StringBuffer binary = new StringBuffer();
//        convertToBinary(n,binary);
//        int count = 0;
//        for(int i=0;i<binary.length();i++){
//            if(binary.charAt(i) == '1'){
//                count++;
//            }
//        }
//        return count;
//    }


    //using right shift -> (O(b)), where (b) is the number of bits processed, with (b <= 32) -> O(1)
//    public int hammingWeight(int n) {
//        int count =0;
//        while(n != 0){
//            count += n&1;
//            n = n>>>1;
//        }
//        return count;
//    }

    //Kernighan's Algo -> O(k),k is number of set bits
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
