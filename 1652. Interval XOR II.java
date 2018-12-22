public class Solution {
    /**
     * @param A: 
     * @param query: 
     * @return: nothing
     */
    public List<Integer> intervalXOR(int[] A, List<Interval> query) {
        List<Integer> result = new ArrayList<>();
        for(Interval que : query){
            int xor = 0;
            for(int i = que.start; i < que.start + que.end; i++){
                xor ^= A[i];
            }
            result.add(xor);
        }
        return result;
    }
}
