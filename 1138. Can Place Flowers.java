public class Solution {
    /**
     * @param flowerbed: an array
     * @param n: an Integer
     * @return: if n new flowers can be planted in it without violating the no-adjacent-flowers rule
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max =0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0)){  //can place a flower here if it's empty, and the neighboring pots are also empty
                flowerbed[i]=1; max++;
                if(max==n) return true;
            }
        }
        if(max >= n) return true;   //if n == 0
        return false;
    }
}
