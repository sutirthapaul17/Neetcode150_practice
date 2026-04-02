package Arrays;

public class ProductOfArrayExceptSelf {

    //Brute force
//    public static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] output = new int[n];
//        for(int i =0;i<n;i++){
//            int product = 1;
//            for(int j = 0;j<n;j++){
//                if(j!=i){
//                    product *= nums[j];
//                }
//            }
//            output[i] = product;
//        }
//        return output;
//    }

    //suffix-prefix array
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] prefix= new int[n];
        int[] sufix =  new int[n];
        prefix[0] = 1;
        sufix[n-1] = 1;

        for(int i = 1;i<n;i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i = n-2;i>=0;i--){
            sufix[i] = sufix[i+1] * nums[i+1];
        }

        for(int i=0;i<n;i++){
            output[i] = prefix[i] * sufix[i];
        }
        return output;
    }



    public static void main(String[] args) {
        int[] nums = {1,2,4,6};
        int[] op =  productExceptSelf(nums);
        for(int ele:op){
            System.out.print(ele+" ");
        }
    }
}
