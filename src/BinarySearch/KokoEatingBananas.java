package BinarySearch;

public class KokoEatingBananas {
//    public int minEatingSpeed(int[] piles, int h) {  // ->TLE
//        int n = piles.length;
//        double k = 0;
//        int max=0;
//
//        for(int ele : piles){
//            max= Math.max(max,ele);
//        }
//        while(k<=max){
//            int sum = 0;
//            k++;
//            for (int pile : piles) {
//                sum += (int) Math.ceil(pile / k);
//                System.out.println(sum);
//            }
//            if(sum <= h) break;
//        }
//        return (int)k;
//    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int ele : piles){
            high= Math.max(high,ele);
        }

        while(low < high){
            int mid = low + (high-low)/2;

            if (canFinish(piles, h, mid)) {
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        int hour = 0;
        for(int ele:piles){
            hour += (ele + k -1)/k;
        }
        return hour <= h;
    }
}
