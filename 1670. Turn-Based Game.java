public class Solution {
    /**
     * @param atk: the atk of monsters
     * @return: Output the minimal damage QW will suffer
     */
    public long getAns(int[] atk) {
        long result = 0;
        Arrays.sort(atk);
        int frq = atk.length - 1;
        System.out.println(frq);
        for (int a: atk) {
            result += (long) a * frq--; //weakest monster gets to survive the longest (inflict most damage) because QW takes care 
            //of strongest monsters first
        }
        return result;
    }
}
