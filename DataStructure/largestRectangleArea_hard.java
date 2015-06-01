/*
Largest Rectangle in Histogram
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.
For example,
Given height = [2,1,5,6,2,3],
return 10.
*/
/*
O(n) runtime
*/
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> s = new Stack<Integer>();
        int len = height.length;
        int max = 0;
        int i = 0;
        while (i <= len) {
            if (s.isEmpty() || (i < len && height[i] >= height[s.peek()])) {
                s.push(i);
                i++;
            } else {
                int h = height[s.pop()];
                int width;
                if (s.isEmpty()) {
                    width = i;
                } else {
                    width = i - s.peek() - 1;
                }
                max = Math.max(max, h * width);
            }
        }
        return max;
    }
}
