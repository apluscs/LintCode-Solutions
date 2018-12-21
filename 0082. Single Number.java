public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        HashSet<Integer> found = new HashSet<>();
        for(int a : A){
            if(found.contains(a) != true){
                found.add(a);
            } else {
                found.remove(a);
            }
        }
        for(int res : found){
            return res;
        }
        return 0;
    }
}
