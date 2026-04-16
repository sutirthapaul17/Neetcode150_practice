package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    //Brute force
//    public int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        int maxArea = -1;
//        for(int i=0;i<n;i++){
//            int minHeight = heights[i];
//            for(int j=i;j<n;j++){
//                int width = (j-i+1);
//                minHeight = Math.min(heights[j],minHeight);
//                int area = minHeight * width;
//                maxArea = Math.max(area,maxArea);
//            }
//        }
//
//        return maxArea;
//    }

    //Optimised
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = -1;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        //NSL(left -> right)
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            left[i] = st.isEmpty()? -1:st.peek();
            st.push(i);
        }
        st.clear();  // important

        //NSR(right -> left)
        for(int i =n-1;i>=0;i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            right[i] = st.isEmpty()? n:st.peek();
            st.push(i);
        }

        for(int i=0;i<n;i++){
            int width = right[i] - left[i] -1;
            int area = heights[i] * width;
            maxArea = Math.max(area,maxArea);
        }

        return maxArea;
    }
}
