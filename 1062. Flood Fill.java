public class Solution {
    /**
     * @param image: a 2-D array
     * @param sr: an integer
     * @param sc: an integer
     * @param newColor: an integer
     * @return: the modified image
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int srcColor=image[sr][sc];
        flood(image,sr,sc,newColor,srcColor);
        return image;
    }
    
    private void flood(int[][] image, int sr, int sc, int newColor, int srcColor){
        if(sr>-1 && sr<image.length && sc>-1&&sc<image[0].length && image[sr][sc]==srcColor){
            image[sr][sc]=newColor; //prettier if we check conditions at the beginning of the recursive call
        } else{
            return;
        }
        flood(image,sr-1,sc,newColor,srcColor);
        flood(image,sr+1,sc,newColor,srcColor);
        flood(image,sr,sc-1,newColor,srcColor);
        flood(image,sr,sc+1,newColor,srcColor);
    }
}
