public class Solution {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if (heights.length < 3) return 0;
        int[] left = new int[heights.length]; //highest peak to the left encountered
        int[] right = new int[heights.length];
        int peak = heights[0];
        for (int i = 0; i < heights.length; i++) {
            peak = Math.max(heights[i], peak); //sometimes it is its own peak
            left[i] = peak;
        }
        peak = heights[heights.length - 1];
        for (int i = heights.length - 1; i >= 0; i--) {
            peak = Math.max(heights[i], peak);
            right[i] = peak;
        }
        int result = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            result += Math.min(left[i], right[i]) - heights[i]; //a bucket is only as good as its shortest wall
        }
        return result;
    }
}
