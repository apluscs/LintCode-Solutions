public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        int pos = 0;
        for(int c = 1; c <= k; c++){
            for(int i = 0; i < colors.length; i++){
                if(colors[i] == c){
                    swap(colors, i, pos++);
                }
            }
        }
    }
    
    public void swap(int[] colors, int a, int b){
        int temp = colors[a];
        colors[a] = colors[b];
        colors[b] = temp;
        
    }
}
