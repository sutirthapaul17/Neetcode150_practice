package MathAndGeometry;

public class HappyNumber {

//    public boolean isHappy(int n) {
//        int[] dp = new int[1000+1];
//        Arrays.fill(dp,0);
//        return checkIfNooCyclical(n,dp);
//    }
//    private boolean checkIfNooCyclical(int n,int[] dp){
//        if(n==1) return true;
//        if(dp[n] == 1) return false;
//        dp[n] = 1;
//        int p = 0;
//        while(n != 0){
//            p+=  (n%10) * (n%10);
//            n/=10;
//        }
//
//        return checkIfNooCyclical(p,dp);
//
//    }

//    public boolean isHappy(int n) {
//
//        Set<Integer> hashset = new HashSet<>();
//        return checkIfNooCyclical(n,hashset);
//    }
//    private boolean checkIfNooCyclical(int n,Set<Integer> hashSet){
//        if(n==1) return true;
//        if(hashSet.contains(n)) return false;
//        hashSet.add(n);
//        int p = 0;
//        while(n != 0){
//            p+=  (n%10) * (n%10);
//            n/=10;
//        }
//
//        return checkIfNooCyclical(p,hashSet);
//
//    }

    public boolean isHappy(int n) {

        while (n != 1 && n!=4 ) {
            int sum = 0;

            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        return n==1;
    }
}
