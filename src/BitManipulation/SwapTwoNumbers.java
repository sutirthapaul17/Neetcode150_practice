package BitManipulation;

public class SwapTwoNumbers {

    private void swap(int a,int b){
        a = a ^ b;
        b = a^b;
        a=a^b;
    }
}
