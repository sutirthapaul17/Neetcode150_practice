package TwoPointer;

public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int ans=0;
        int i=0,j= heights.length-1;
        while (i < j) {
            int temp = (j-i) * Math.min(heights[i],heights[j]);
            ans = Math.max(ans, temp);
            if(heights[j] >= heights[i]) i++;
            else j--;
        }
        return ans;
    }
}
