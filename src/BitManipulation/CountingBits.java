package BitManipulation;

public class CountingBits {

    //Brute force -> O(nlogn)
//    public int[] countBits(int n) {
//        int[] ans = new int[n+1];
//        ans[0] = 0;
//        for(int i=1;i<=n;i++){
//            int count =0;
//            int k = i;
//            while(k!=0){
//                k = (k & k-1);
//                count++;
//            }
//            ans[i]= count;
//        }
//        return ans;
//    }

    //using karnighan and recurrence relation , t.c->O(n).A.S-> O(n)
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i=1;i<=n;i++){
            ans[i] = ans[i&(i-1)] + 1;
        }
        return ans;
    }

    //using rightshift and Bitwise and , t.c->O(n).A.S-> O(n)
//    public int[] countBits(int n) {
//        int[] ans = new int[n+1];
//
//        for(int i=1;i<=n;i++){
//            ans[i] = ans[i >> 1] + (i&1);
//        }
//        return ans;
//    }
}
