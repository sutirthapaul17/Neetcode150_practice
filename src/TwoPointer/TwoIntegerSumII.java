package TwoPointer;

public class TwoIntegerSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int l =0,h=numbers.length-1;
        System.out.println("Entering loop.......");
        while(l<h){
            System.out.println("Inside loop.............");
            System.out.println("l:"+l+" ,h:"+h);
            System.out.println("numbers[l]:"+numbers[l]+" ,numbers[h]:"+numbers[h]);
            if(numbers[l] + numbers[h] == target){
                return new int[]{l+1 ,h+1};
            }
            if(numbers[l] + numbers[h] > target) h--;
            if(numbers[l] + numbers[h] < target) l++;

        }
        System.out.println("Exiting loop.......");
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        int[] ans = twoSum(numbers,5);
        System.out.println("Returned array:");
        for(int ele : ans){
            System.out.print(ele+" ");
        }
    }
}
