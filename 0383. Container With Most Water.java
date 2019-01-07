public class Solution {
    /**
     * @param heights: a vector of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int result = 0;
        while (left < right) { //finds max area for each possible width, result saves max of these findings
            int area = 0;
            if (heights[left] < heights[right]) { //if left binds you, try a new left
                area = (right - left) * heights[left++];
            } else {
                area = (right - left) * heights[right--];
            }
            result = Math.max(area, result);
        }
        return result;
    }
}
