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

//less cringey solution :D
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if(colors.length < 2){
            return;
        }
        for(int c = 0; c < k; c++){
            if(colors[c] < 0) continue;   //colors[c] is in the right place
            int lost = colors[c];
            int nextLoc = lost-1;   //where lost SHOULD be
            colors[c] = 0;  //marked as empty home
            while(lost > 0){
                if(colors[nextLoc] > 0){    //another is is lost's place
                    System.out.println("hi " + lost + " " + nextLoc);
                    lost = colors[nextLoc];    //new body is now marked as lost
                    colors[nextLoc] = -1;   //initial lost takes residence
                    nextLoc = lost-1;
                    // System.out.println(Arrays.toString(colors) + " " + nextLoc);
                } else {
                    colors[nextLoc]--;  //one more resident of this home
                    break;
                }
            }
        }
        for(int i = k; i < colors.length; i++){
            colors[colors[i]-1]--;  //marks frqs of all others in array
        }
        int pos = colors.length-1;
        for(int i = k-1; i>=0;i--){
            int col = i + 1;
            int frq = -colors[i];
            for(int j = 0; j < frq; j++){
                colors[pos--] = col;
            }
        }
    }
}
