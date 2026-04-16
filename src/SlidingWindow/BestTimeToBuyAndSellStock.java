package SlidingWindow;

public class BestTimeToBuyAndSellStock {
    //Kadane's algo
    public int maxProfit(int[] prices) {
        int minPrice =  prices[0],max =0;
        for(int price : prices ){
            minPrice = Math.min(price,minPrice);
            max = Math.max(max,price - minPrice);
        }
        return max;
    }


    //Sliding window
//    public int maxProfit(int[] prices) {
//        int left=0 , right = left+1;
//        int max =0;
//        while(right < prices.length){
//            if(prices[left] > prices[right]){
//                left = right;
//            }else{
//                max = Math.max(max,prices[right] - prices[left]);
//            }
//            right++;
//        }
//        return max;
//    }
}
