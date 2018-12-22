public class Solution {
    /**
     * @param array: the input array
     * @return: the sorted array
     */
    public int[][] multiSort(int[][] array) {
        int[][] result = array;
        Arrays.sort(result, (a, b) -> {
           if(a[1] != b[1]){
               return b[1] - a[1];
           } else{
               return a[0] - b[0];
           }
        });
        return result;
    }
}
